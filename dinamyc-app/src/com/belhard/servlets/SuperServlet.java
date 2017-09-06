package com.belhard.servlets;

import com.belhard.utils.Connector;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;

public abstract class SuperServlet extends HttpServlet {

    enum  roomlist {AUTOMOTO, SPORT, FINANCE}

    public static void getData(JspWriter jspWriter, Enum roomname) {
        String roomStringName = roomname.name().toLowerCase();

        try {
            Connector connector = new Connector();
            Statement statementResponse = connector.getConnection().createStatement();
            ResultSet resultSet = statementResponse.executeQuery("SELECT user , message, datetime " +
                    "FROM Forum." + roomStringName +" ORDER BY id");
            while (resultSet.next()) {
                String user =  resultSet.getString("user");
                String message = resultSet.getString("message");
                String datetime = resultSet.getString("datetime");
                String newRow = stringRow(user,message,datetime);
                jspWriter.println(newRow);
            }
//            req.setAttribute("roomname", roomStringName);
//            req.getRequestDispatcher("/room.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage( String user, String message,
                                   LocalDateTime dateTime, Enum roomname) {
        Connector connector = new Connector();
        String roomStringName = roomname.name().toLowerCase();
        try {
            Statement statement = connector.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO Forum." + roomStringName +
                    " (`user`, `message`, `datetime`) VALUES ('" + user + "','" + message + "','" + dateTime + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String stringRow( String user,String message,String datetime) {
        String newRow  = " <tr class=\"rows\">\n" +
               "            <td class=\"users\">" + user + "</td>\n" +
               "            <td class=\"messages\">" + message + "</td>\n" +
               "            <td class=\"date\">" + datetime + "</td>\n" +
               "        </tr>";
        return newRow;
    }

    public static String getLoginCookies(Cookie[] cookies) {
        for (Cookie cook :
                cookies) {
            String cookString = cook.getName();
            if (cookString.equals("login")) {
                return cook.getValue();
            }
        }
        return null;
    }

    public static String getPasswordCookies(Cookie[] cookies) {
        for (Cookie cook :
                cookies) {
            String cookString = cook.getName();
            if (cookString.equals("password")) {
                return cook.getValue();

            }
        }
        return null;
    }

    public static String getNameCookies(Cookie[] cookies) {
        for (Cookie cook :
                cookies) {
            String cookString = cook.getName();
            if (cookString.equals("name")) {
                return cook.getValue();

            }
        }
        return null;
    }

    @Override
    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;










}
