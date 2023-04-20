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
        .signupFrm {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form {
            background-color: white;
            width: 420px;
            border-radius: 8px;
            padding: 20px 40px;
            box-shadow: 0 10px 25px rgba(92, 99, 105, .2);
        }

        .title {
            font-size: 50px;
            margin-bottom: 50px;
        }
        .inputContainer {
            position: relative;
            height: 45px;
            width: 90%;
            margin-bottom: 17px;
        }
        .input {
            position: absolute;
            top: 0px;
            left: 0px;
            height: 100%;
            width: 68%;
            border: 1px solid #DADCE0;
            border-radius: 7px;
            font-size: 16px;
            padding: 0 20px;
            outline: none;
            background: none;
            z-index: 1;
        }
        ::placeholder {
            color: transparent;
        }

        .submitBtn {
            display: block;
            margin-left: auto;
            padding: 15px 30px;
            border: none;
            background-color: purple;
            color: white;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 30px;
        }

        .submitBtn:hover {
            background-color: #9867C5;
            transform: translateY(-2px);
        }
        .alter{
            margin-left: 260px;
            text-align: left;
            font-size: 5px;
            color: red;

        }

        a{
            font-size: 15px;
            font-color: blue;
            text-decoration:none;
        }
        a:hover {
            font-size: 10px;
            font-color: purple;
            text-decoration:none;
        }
        .submitBtn:hover {
            background-color: #9867C5;
            transform: translateY(-2px);
        }
        input::placeholder {
            color: gray;
        }
    </style>
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
<body >
<div class="signupFrm">
    <form action="CheckUser"  onsubmit="return check()" class="form" method="get">
        <h1 class="title">Login</h1>
        <div class="inputContainer">
            <span><input class="input" type="text" name="username" id="username" placeholder="Username"  autofocus required ></span>
        </div>
        <div class="inputContainer">
            <span><input class="input" type="password" name="password" id="password" placeholder="Password" required onblur="checkuserpassword()"></span>
            <span id="UserPasswordCheck" class="alter"></span>
        </div>
        <a href="sign_up.jsp" >Sign up</a>
        <input type="submit" class="submitBtn" value="Log in" >
    </form>

</div>
</body>
</html>
