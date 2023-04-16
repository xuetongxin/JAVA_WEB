package com.example.genealogy;

import java.io.*;

import jakarta.servlet.http.*;
import com.example.genealogy.DBC.*;
public class CheckUserName extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);// 在这里处理表单数据，比如验证用户名和密码是否正确
        CheckUser checkUser=new CheckUser();
        if(checkUser.checkUser(username,password)) {
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }
        // 重定向到登录成功页面
        //response.sendRedirect("src/main/webapp/WEB-INF/login_success.jsp");
    }
}