package com.belhard.servlets;


import com.belhard.utils.Constants;
import com.belhard.utils.Product;
import javafx.scene.layout.BorderPane;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/shop")
public class MagazineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Boolean> spisok = new HashMap<Product, Boolean>();

        Cookie[] cookies = req.getCookies();

        for (Product product : Constants.products) {
            boolean canBy = true;
            for (Cookie cook :
                    cookies) {
                if (cook.getName().equals("product_" + product.getName())) {
                    canBy = Boolean.valueOf(cook.getValue());
                    break;
                }
            }
            spisok.put(product, canBy);
        }

        req.setAttribute("spisok", spisok);
        req.getServletContext().getRequestDispatcher("/magazine.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean buy = Boolean.valueOf(req.getParameter("buy"));
        Cookie[] cookies = req.getCookies();
        Boolean isCookExist =  false;
        String productName = req.getParameter("product");
        for (Cookie c :
                cookies) {
            if (c.getName().equals("product_" + productName)) {
                c.setValue(buy.toString());
                resp.addCookie(c);
                isCookExist = true;
            }

        }
        if (!isCookExist) {
            resp.addCookie(new Cookie("product_" + productName, buy.toString()));
        }
        doGet(req, resp);


    }

    private void getProducts() {

    }
}
