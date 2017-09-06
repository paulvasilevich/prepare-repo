<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 31.08.17
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Решение квадратных уравнений</title>
</head>
<body>
<div>
    Entered equation: <B>${equation}</B> <br>
    Discriminant: <B>${D}</B><br>
    X1: <B>${x1}</B><br>
    X2: <B>${x2}</B><br>
    Errors: ${errors}<br>
</div>
<form action="sum.html" method="get">
    <input  type="submit" value="Calculate Another Equation">
</form>
</body>
</html>
