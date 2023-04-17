package com.example.genealogy;

import java.io.*;

import com.example.genealogy.bean.User;
import jakarta.servlet.http.*;
import com.example.genealogy.DBC.*;
public class CheckUserName extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        User user =new User();
        user.setUsername( request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        CheckUser checkUser=new CheckUser();
        if(checkUser.checkUser(user.getUsername(),user.getPassword()))
            response.sendRedirect("login_success.jsp");
    }
}