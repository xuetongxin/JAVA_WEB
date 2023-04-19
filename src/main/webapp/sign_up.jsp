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
            width: 100%;
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
        .label {
            position: absolute;
            top: 15px;
            left: 15px;
            padding: 0 4px;
            background-color: white;
            color: #DADCE0;
            font-size: 16px;
            transition: 0.5s;
            z-index: 0;
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
        a{
            display: block;
            text-align: left;
            margin-top: 20px;
            font-size: 8px;
            color: blue;
            text-decoration:none;
        }
        input::placeholder {
            color: gray;
        }
    </style>
    <script type="text/javascript">
        function checkpassword() {
            var password = document.getElementById("password").value;
            var repassword = document.getElementById("repeat_password").value;
            if(password == repassword) {
                return true;
            }else {
                alert("两次密码输入不一致，请重新输入！");
            }
            return false
        }
    </script>
</head>
<body>
<div class="signupFrm" >
    <form action="SingUp" class="form" onsubmit="return checkpassword()" method="get">
        <h1 class="title">Sign up</h1>

        <div class="inputContainer">
            <input type="text" class="input" name="email" id="email" placeholder="Email">
        </div>

        <div class="inputContainer">
            <input type="text" class="input" name="username" id="username" placeholder="UserName">
        </div>

        <div class="inputContainer">
            <input type="password" class="input" name="password" id="passw" placeholder="Password">
        </div>

        <div class="inputContainer">
            <input type="password" class="input"   id="repeat_password" placeholder="Repeat Password"><span id="insert"></span>
        </div>

        <a href="login.jsp">Already have an account?</a>

        <input type="submit"  class="submitBtn" id="submit" name="submit" value="Sign up">
    </form>
</div>
</body>
</html>
