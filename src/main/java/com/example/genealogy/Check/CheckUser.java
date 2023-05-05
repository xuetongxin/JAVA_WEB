package com.example.genealogy.Check;

import java.io.*;

import com.example.genealogy.bean.User;
import jakarta.servlet.http.*;
import com.example.genealogy.DBC.*;
public class CheckUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        User user =new User();
        UserDB userDB=new UserDB();
        user.setUsername( request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if(userDB.checkUser(user)){
            response.sendRedirect("main.jsp");
        }else {
            response.setContentType("text/plain");
            response.getWriter().write("用户不存在");
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
            doGet(request,response);
    }
}