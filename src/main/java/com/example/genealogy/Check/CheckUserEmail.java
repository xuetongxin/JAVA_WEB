package com.example.genealogy.Check;

import com.example.genealogy.DBC.UserDB;
import com.example.genealogy.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheckUserEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDB userDB=new UserDB();
        User user=new User();
        user.setEmail(req.getParameter("email"));
        if (userDB.IsEmailExist(user)){
            resp.setContentType("text/plain");
            resp.getWriter().write("邮箱已注册");
        }else {
            resp.setContentType("text/plain");
            resp.getWriter().write("邮箱可用");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
