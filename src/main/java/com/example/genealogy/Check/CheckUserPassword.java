package com.example.genealogy.Check;

import com.example.genealogy.DBC.UserDB;
import com.example.genealogy.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheckUserPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User(username,password);
        UserDB userDB=new UserDB();
        if (!userDB.checkUser(user)){
            resp.setContentType("text/plant");
            resp.getWriter().write("用户名或者密码不正确");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
