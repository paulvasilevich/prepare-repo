<%@ page import="com.belhard.servlets.SuperServlet" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: white
  Date: 30.08.17
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${roomname}</title>
    <style>
        body{
            background-color: seashell;
        }

        h1{
            color: black;
            padding-top: 1cm;
        }
        tr.rows {
            color: black;
            margin-left: 20px;

            border: #67595b medium solid;
        }
        td.users {
            font-family: TakaoPGothic;
            font-style: italic;
            font-size: large;
            color: darkred;
            border: dotted;
        }

    </style>
</head>
<body>

<div class="divElements">
    <table>
        <%
            Enum room = (Enum) request.getAttribute("roomEnum");
            SuperServlet.getData(out, room);
        %>
    </table>
</div>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c :
                cookies) {
            if (c.getName().equals("loginStatus") && c.getValue().equals("true")) {
                out.println("<h1>You entered as, " + SuperServlet.getNameCookies(cookies) + " !</h1>" +
                        "<form action=\"/");%> ${roomname}
<%
                        out.println(".room\" method=\"post\">\n" +
                        "    <input type=\"text\" name=\"message\"  placeholder=\"Message...\"/>\n" +
                        "    <input type=\"submit\" name=\"submit_message\" value=\"Send\"/>\n" +
                        "</form>");
                out.println(
                        "<form action=\"/index.html\" method=\"get\" >\n" +
                                "    <input type=\"submit\"  value=\"exit\"/>\n" +
                                "</form>"
                );
            }
        }
    }
%>

</body>
</html>
