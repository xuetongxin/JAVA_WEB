<%--
  Created by IntelliJ IDEA.
  User: xsl20
  Date: 2023/4/16
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:useBean id="users" class="com.example.genealogy.bean.User" scope="session"/>
    <title>welcome to here</title>
</head>
<body>
    <%!

    %>
    <h1><%=users.getUsername()%></h1>

</body>
</html>
