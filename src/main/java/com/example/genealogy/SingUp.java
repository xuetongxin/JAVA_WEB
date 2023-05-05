package com.example.genealogy;

import com.example.genealogy.DBC.UserDB;
import com.example.genealogy.Dao.UserDaoImpl;
import com.example.genealogy.EMAIL.SendEmail;
import com.example.genealogy.bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SingUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User user = new User();
            user.setEmail(req.getParameter("email"));
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            UserDB userDB=new UserDB();
            userDB.Insert_Into_User(user);
            //System.out.println("插入成功");

            SendEmail sendEmail = new SendEmail(user.getEmail(),user.getUsername());
            sendEmail.start();

            req.setAttribute("username",user.getUsername());
            RequestDispatcher dispatcher = req.getRequestDispatcher("Register_After.jsp");
            dispatcher.forward(req,resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
