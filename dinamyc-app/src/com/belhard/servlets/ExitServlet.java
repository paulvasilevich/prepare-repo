package com.belhard.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exit.room")
public class ExitServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie :
//                    cookies) {
//                cookie.setValue(null);
//                cookie.setPath("/index.html");
//                cookie.setMaxAge(1);
//                resp.addCookie(cookie);
//            }
//        }
//        req.getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
    }
}
