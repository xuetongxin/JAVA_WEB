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
    <link rel="stylesheet" type="text/css" href="CSS/title.css">
    <link rel="stylesheet" type="text/css" href="CSS/body.css">
    <link rel="stylesheet" type="text/css" href="CSS/form.css">
    <link rel="stylesheet" type="text/css" href="CSS/input.css">
    <link rel="stylesheet" type="text/css" href="CSS/submit.css">
    <link rel="stylesheet" type="text/css" href="CSS/alter.css">
    <link rel="stylesheet" type="text/css" href="CSS/signup.css">
    <script>
        function check() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var regex_username = /^[a-zA-Z0-9]{6,20}$/;
            var regex_password = /^.{8,20}$/;
            if (!regex_username.test(username)) {
                alert("用户名长度8-20，只能包含数字、字母");
                return false;
            }
            if (!regex_password.test(password)) {
                alert("密码长度8——20位");
                return false
            }
        }
        function checkuserpassword() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("UserPasswordCheck").innerHTML = this.responseText;

                }
            };
            xmlhttp.open("GET", "CheckUserPassword?username=" + username+"&&password="+password, true);
            xmlhttp.send();
        }
    </script>
</head>
<body background="CSS/img/background.jpg">
<div class="signupFrm">
    <script async src="https://cse.google.com/cse.js?cx=508c4ea960be0496f">
    </script>

    <form action="CheckUser"  onsubmit="return check()" class="form" method="get">
        <div class="gcse-search"></div>
        <h1 class="title">Login</h1>
        <div class="inputContainer">
            <span><input class="input" type="text" name="username" id="username" placeholder="Username"  autofocus required ></span>
        </div>
        <div class="inputContainer">
            <span><input class="input" type="password" name="password" id="password" placeholder="Password" required onblur="checkuserpassword()"></span>
            <span id="UserPasswordCheck" class="alter"></span>
        </div>
        <div height="200px">
            <a href="sign_up.jsp" >Sign up</a>
        </div>

        <input type="submit" class="submitBtn" id="submit" value="Log in" >
    </form>

</div>
</body>
</html>
