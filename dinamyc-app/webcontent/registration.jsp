<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 31.08.17
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<table>
    <form action="registration.do" method="post">

        <tr>
            <td>User login:</td>
            <td>
                <input type="text" name="txt_user_login" placeholder="Enter login...">
            </td>
        </tr>
        <tr>
            <td>User password:</td>
            <td>
                <input type="password" name="txt_user_password" placeholder="Enter password...">
            </td>
        </tr>
        <tr>
            <td>User full name:</td>
            <td>
                <input type="text" name="txt_user_fullName" placeholder="Enter full name...">
            </td>
        </tr>
        <tr>
            <td>User birth date:</td>
            <td>
                <input type="text" name="txt_user_birthDate" >
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" name="submit_register" value="Register">
            </td>
    </form>
    <form action="index.html">
        <td colspan="1" align="left">
            <input type="submit" name="submit_return" value="Return">
        </td>
    </form>
    </tr>



</table>
</body>
</html>
