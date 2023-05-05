package com.example.genealogy.Check;

import com.example.genealogy.DBC.UserDB;
import com.example.genealogy.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheckUserName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDB userDB=new UserDB();
        User user=new User();
        user.setUsername(req.getParameter("username"));
        if (userDB.IsNameExist(user)){
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

