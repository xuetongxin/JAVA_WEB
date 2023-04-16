package com.example.genealogy.DBC;

import java.sql.SQLException;
import java.sql.Statement;

public class CheckUser {
    JDBC jdbc=new JDBC();
    public boolean checkUser(String username,String password){
        String sql="select count(*) from user where username='"+username+"' and password='"+password+"'";
        try {
            Statement statement=jdbc.getConnection().createStatement();
            int count=statement.executeUpdate(sql);
            if(count>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
