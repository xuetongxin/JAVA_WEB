<%--
  Created by IntelliJ IDEA.
  User: xsl20
  Date: 2023/4/16
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-image: url("img/background.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }
        table{
            margin-top: 200px;
            margin-left: 500px;
            border-collapse: collapse;
        }
        td{
            text-align: center;
        }
        .username{
            font-family: 华文行楷;
        }
        .password{
            font-family: 华文行楷;
        }
    </style>
</head>
<body >
<table>
    <form action="CheckUser" method="get">
        <tr>
            <td >username:</td>
            <td><input type="text" name="username" placeholder="username" value="123456" require  autofocus> </td>
        <tr>
            <td>password:</td>
            <td><input type="password" name="password" placeholder="password" value="123456" required></td>
        <tr>
            <td></td>
            <td><input type="submit" value="login"></td>
    </form>
</table>
</body>
</html>
