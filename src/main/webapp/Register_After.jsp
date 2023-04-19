<%--
  Created by IntelliJ IDEA.
  User: xsl20
  Date: 2023/4/18
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html charaset="UTF-8">
<head>
    <script>
        var username = "${username}";
        window.onload = function() {
            alert(username+ " 你的邮件已发送，前往邮箱验证");
        };
    </script>
</head>
</html>
