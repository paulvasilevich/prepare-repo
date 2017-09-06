package com.belhard.servlets;


import com.belhard.utils.Connector;
import com.belhard.utils.DatabaseUsers;
import com.belhard.utils.Message;

import javax.ejb.SessionContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

@WebServlet("/automoto.room")
public class AutoMotoServlet extends SuperServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String user = getNameCookies(cookies);
        String message = req.getParameter("message");
        sendMessage(user, message, LocalDateTime.now(), roomlist.AUTOMOTO);
        doGet(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enum room = SuperServlet.roomlist.AUTOMOTO;
        req.setAttribute("roomEnum", room);
        String roomName = room.toString().toLowerCase();
        req.setAttribute("roomname", roomName);
        req.getServletContext().getRequestDispatcher("/room.jsp").forward(req,resp);


    }


//    private boolean getStatusCookies(Cookie[] cookies) {
//        for (Cookie cook :
//                cookies) {
//            String cookString = cook.getName();
//            if (cookString.equals("loginStatus")) {
//                 return cook.getValue().equals("true");
//
//            }
//        }
//        return false;
//    }
}
