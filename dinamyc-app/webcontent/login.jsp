<%@ page import="com.belhard.servlets.SuperServlet" %><%--
  Created by IntelliJ IDEA.
  User: white
  Date: 31.08.17
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h2 align="center" > <a href="/automoto.room" methods="POST"> Auto & Moto room.</a> |
    <a href="/finance.room" methods="POST">Finance room.</a> |
    <a href="/sport.room" methods="POST">Sport's room.</a></h2>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
            for (Cookie c :
                    cookies) {
                if (c.getName().equals("loginStatus") && c.getValue().equals("true")) {
                    String name = SuperServlet.getNameCookies(cookies);
                    request.setAttribute("name", name);
                    pageContext.getServletContext().getRequestDispatcher("/afterLoginSuccess.jsp").forward(request, response);
                    break;
                }
            }
        response.sendRedirect("/index.html");
    } else {
        response.sendRedirect("/index.html");
//        out.println("<table>\n" +
//                "    <form action=\"/enter\" method=\"post\">\n" +
//                "\n" +
//                "        <tr>\n" +
//                "            <td>Login:</td>\n" +
//                "            <td>\n" +
//                "                <input type=\"text\" name=\"txt_user_login\" />\n" +
//                "            </td>\n" +
//                "        </tr>\n" +
//                "        <tr>\n" +
//                "            <td>Password:</td>\n" +
//                "            <td>\n" +
//                "                <input type=\"password\" name=\"txt_user_password\" />\n" +
//                "            </td>\n" +
//                "        </tr>\n" +
//                "        <tr>\n" +
//                "            <td colspan=\"2\" align=\"right\">\n" +
//                "                <input type=\"submit\" value=\"Enter\" name=\"submit_enter\" />\n" +
//                "            </td>\n" +
//                "    </form>\n" +
//                "    <form action=\"registrationPage.html\">\n" +
//                "        <td colspan=\"3\" align=\"left\">\n" +
//                "            <input type=\"submit\" name=\"submit_registration\" value=\"Registration\">\n" +
//                "        </td>\n" +
//                "    </form>\n" +
//                "    </tr>\n" +
//                "</table>");
    }
%>


</body>
</html>
