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
    <style>
        body {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            background-color: white;
            font-family: "lato", sans-serif;
        }

        .signupFrm {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form {
            background-color: white;
            width: 400px;
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
            width: 80%;
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
            margin-left: 300px;
            text-align: right;
            font-size: 6px;
            color: red;
            margin-top: 10px;
        }
        a {
            display: block;
            text-align: left;
            margin-top: 20px;
            font-size: 8px;
            color: blue;
            text-decoration: none;
        }

        input::placeholder {
            color: gray;
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
            var username = document.getElementById("username").value;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("UserEmailCheck").innerHTML = this.responseText;
                }
            };
            xmlhttp.open("GET", "CheckUserEmail?username=" + username, true);
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

        <a href="login.jsp">Already have an account?</a>

        <input type="submit" class="submitBtn" id="submit" name="submit" value="Sign up">
    </form>
</div>
</body>
</html>
