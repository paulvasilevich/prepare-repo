package com.belhard.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.NaN;

@WebServlet("/quadEquation")
public class Mathematics extends HttpServlet {

    private static final String A = "a";
    private static final String SYM1 = "sym1";
    private static final String B = "b";
    private static final String SYM2 = "sym2";
    private static final String C = "c";

    private double discr;
    private double x1;
    private double x2;
    private String equation;
    private String errors;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String a = req.getParameter(A);
        String sym1 = req.getParameter(SYM1);
        String b = req.getParameter(B);
        String sym2 = req.getParameter(SYM2);
        String c = req.getParameter(C);

        equation = a + "x^2 " + sym1 + " " + b + "x " + sym2 + " " + c + " = 0";


        if (checkAllEquation(a, sym1, b, sym2, c, req)) {
            int aInt = Integer.parseInt(a);
            int bInt = Integer.parseInt(b);
            int cInt = Integer.parseInt(c);
            discr = calcDiscr(aInt, bInt, cInt);

            if (discr > 0) {
                x1 = (-bInt - Math.sqrt(discr)) / (2 * aInt);
                x2 = (-bInt + Math.sqrt(discr)) / (2 * aInt);
            } else if (discr == 0) {
                x1 = x2 = (-bInt) / (2 * aInt);
            } else if (discr < 0) {
                x1 = x2 = NaN;
            }
            req.setAttribute("status", true);
            req.setAttribute("equation", equation);
            req.setAttribute("D", discr);
            req.setAttribute("x1", x1);
            req.setAttribute("x2", x2);
            req.getServletContext().getRequestDispatcher("/mathematics.jsp").forward(req, resp);
        } else {
            req.setAttribute("errors" , errors);
            req.setAttribute("status", false);
            req.setAttribute("equation", equation);
            req.setAttribute("D", "Not calculated");
            req.setAttribute("x1", "Not calculated");
            req.setAttribute("x2", "Not calculated");
            req.getServletContext().getRequestDispatcher("/mathematics.jsp").forward(req, resp);
        }

    }

    private double calcDiscr(int a,int b,int c ) {

        double discr =  (Math.pow(b, 2) - 4 * a * c);
        return discr;
    }

    private boolean checkAllEquation(String a,String sym1,String b,String sym2,String c,HttpServletRequest req) {
        if (checkingOnNumber(a) && checkingOnSymbol(sym1) && checkingOnNumber(b) &&
                checkingOnSymbol(sym2) && checkingOnNumber(c)) {
            return true;
        } else {
            String erorMsg = "";
            if (!checkingOnNumber(a)) {
              erorMsg =  erorMsg.concat( " Wrong input data. " + a + " Check it please. <br>");
            }  if (!checkingOnNumber(sym1)) {
                erorMsg =  erorMsg.concat( "Wrong input data. " + sym1 + " Check it please.<br>");
            }  if (!checkingOnNumber(b)) {
                erorMsg =  erorMsg.concat( "Wrong input data. " + b + " Check it please. <br>");
            }  if (!checkingOnNumber(sym2)) {
                erorMsg =  erorMsg.concat( "Wrong input data. " + sym2 + " Check it please.<br>");
            }  if (!checkingOnNumber(c)) {
                erorMsg =  erorMsg.concat("Wrong input data. " + c + " Check it please.<br>");
            }
            errors = erorMsg;
            return false;
        }
    }

    private boolean checkingOnNumber(String s) {
        Pattern p = Pattern.compile("^-?\\d*");
        Matcher m = p.matcher(s);

        return m.matches();
    }

    private boolean checkingOnSymbol(String s) {
        Pattern p = Pattern.compile("[-+]");
        Matcher m = p.matcher(s);

        return m.matches();
    }
}
