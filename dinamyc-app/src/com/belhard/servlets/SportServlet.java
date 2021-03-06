package com.belhard.servlets;

import com.belhard.utils.Connector;
import com.belhard.utils.DatabaseUsers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

@WebServlet("/sport.room")
public class SportServlet extends SuperServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enum room = roomlist.SPORT;
        req.setAttribute("roomEnum", room);
        String roomName = room.toString().toLowerCase();
        req.setAttribute("roomname", roomName);
        req.getServletContext().getRequestDispatcher("/room.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String user = getNameCookies(cookies);
        String message = req.getParameter("message");
        sendMessage(user, message, LocalDateTime.now(), roomlist.SPORT);
        doGet(req, resp);
    }
}

