<%@ page import="com.example.genealogy.DBC.UserDB" %>
<%--
  Created by IntelliJ IDEA.
  User: xsl20
  Date: 2023/4/18
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Successfully</title>
</head>
<body>
<p>你的账号已经激活</p>
    <%
        String email=request.getParameter("email");
        UserDB userDB=new UserDB();
        userDB.Update_UserEmail_Statue(email);
    %>
</body>
</html>
