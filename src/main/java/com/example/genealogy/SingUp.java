package com.example.genealogy;

import com.example.genealogy.DBC.JDBC;
import com.example.genealogy.DBC.UserDB;
import com.example.genealogy.EMAIL.SendEmail;
import com.example.genealogy.bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.jar.Attributes;


public class SingUp extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("email"),req.getParameter("username"),req.getParameter("password"));
        UserDB userDB=new UserDB(user);
        try {
            userDB.Insert_Into_User(user);
            System.out.println("插入成功");
            SendEmail sendEmail = new SendEmail(user.getEmail(),user.getUsername());
            sendEmail.start();
            req.setAttribute("username",user.getUsername());
            RequestDispatcher dispatcher = req.getRequestDispatcher("Register_After.jsp");
            dispatcher.forward(req,resp);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
