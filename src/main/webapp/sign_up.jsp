<%--
  Created by IntelliJ IDEA.
  User: xsl20
  Date: 2023/4/17
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="CSS/submit.css">
    <link rel="stylesheet" type="text/css" href="CSS/body.css">
    <link rel="stylesheet" type="text/css" href="CSS/form.css">
    <link rel="stylesheet" type="text/css" href="CSS/title.css">
    <link rel="stylesheet" type="text/css" href="CSS/alter.css">
    <link rel="stylesheet" type="text/css" href="CSS/input.css">
    <style>
        a {
            display: block;
            text-align: left;
            margin-top: 20px;
            font-size: 8px;
            color: blue;
            text-decoration: none;
        }
    </style>
    <script type="text/javascript">
        function check() {
            var email = document.getElementById("email").value;
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var repassword = document.getElementById("repeat_password").value;
            var regex_username = /^[a-zA-Z0-9]{6,20}$/;
            var regex_email = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
            var regex_password = /^.{8,20}$/;

            if (!regex_email.test(email)) {
                alert("邮箱格式不正确");
                return false;
            }
            if (!regex_username.test(username)) {
                alert("用户名长度6-20，只能包含数字、字母");
                return false;
            }
            if (!(regex_password.test(password) && regex_password.test(regex_password))) {
                alert("密码长度8——20位");
                return false
            }
            if (password != repassword) {
                alert("两次密码输入不一致，请重新输入！");
                return false;
            }
        }

        function checkUsername() {
            var username = document.getElementById("username").value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("UserNameCheck").innerHTML = this.responseText;
                }
            };
            xmlhttp.open("GET", "CheckUserName?username=" + username, true);
            xmlhttp.send();
        }
        function checkUseremail() {
            var email = document.getElementById("email").value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("UserEmailCheck").innerHTML = this.responseText;
                }
            };
            xmlhttp.open("GET", "CheckUserEmail?email=" + email, true);
            xmlhttp.send();
        }
    </script>
</head>
<body>
<div class="signupFrm">
    <form action="SingUp" class="form" onsubmit="return check()" method="get">
        <h1 class="title">Sign up</h1>

        <div class="inputContainer">
            <input type="text" class="input" name="email" id="email" placeholder="Email" required autofocus onblur="checkUseremail()">
            <span id="UserEmailCheck" class="alter"></span>
        </div>

        <div class="inputContainer">
            <span><input type="text" class="input" name="username" id="username" placeholder="UserName" required onblur="checkUsername()"></span>
            <span id="UserNameCheck" class="alter"></span>
        </div>

        <div class="inputContainer">
            <input type="password" class="input" name="password" id="password" placeholder="Password" required>
        </div>

        <div class="inputContainer">
            <input type="password" class="input" id="repeat_password" placeholder="Repeat Password" required><span
                id="insert"></span>
        </div>
        <div>
            <a href="login.jsp">Already have an account?</a>
        </div>

        <input type="submit" class="submitBtn" id="submit"  value="Sign up"  onclick="checkUseremail()">
    </form>
</div>
</body>
</html>
