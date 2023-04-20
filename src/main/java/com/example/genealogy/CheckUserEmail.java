package com.example.genealogy;

import com.example.genealogy.DBC.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheckUserEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        UserDB userDB=new UserDB();
        if (userDB.IsEmailExist(email)){
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
