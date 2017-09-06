package com.belhard.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sum")
public class SumServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int a = Integer.valueOf(req.getParameter("a"));
        int a1 = Integer.parseInt(req.getParameter("a"));
        int b = Integer.valueOf(req.getParameter("b"));
        int b1 = Integer.parseInt(req.getParameter("b"));


        int s = a1 + b1;

        req.setAttribute("placeA" , a1);
        req.setAttribute("placeB" , b1);
        req.getServletContext().setAttribute("placeB" , b1);
        req.setAttribute("placeS" , s);
        req.getServletContext().getRequestDispatcher("/sumResults.jsp").forward(req, resp);



    }
}
