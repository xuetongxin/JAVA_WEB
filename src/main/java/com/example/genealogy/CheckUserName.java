package com.example.genealogy;

import com.example.genealogy.DBC.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheckUserName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        UserDB userDB=new UserDB();
        if (userDB.IsNameExist(username)){
            resp.setContentType("text/plain");
            resp.getWriter().write("用户名存在");
        }else {
            resp.setContentType("text/plain");
            resp.getWriter().write("用户名可用");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req,resp);
    }
}

