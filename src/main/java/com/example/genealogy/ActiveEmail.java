package com.example.genealogy;

import com.example.genealogy.DBC.UserDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ActiveEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email= req.getParameter("email");
        UserDB userDB=new UserDB();
        if (userDB.Update_UserEmail_Statue(email)){
            System.out.println("激活成功");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("Register_Success.jsp");
            requestDispatcher.forward(req,resp);
        }


    }

}
