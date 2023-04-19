package com.example.genealogy.DBC;

import com.example.genealogy.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDB {
    User user;

    public UserDB(){}
    public UserDB(User user){
        this.user=user;
    }

    public boolean Insert_Into_User(User user) {
        Connection connection = null;
        try {
            connection = new JDBC().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("insert into users (username,password,email) values(?,?,?)");
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Update_UserEmail_Statue(String email) {

        try{
            Connection connection =new JDBC().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("update user set statue= '1' where email= ? ");
            preparedStatement.setString(1, email);
            return preparedStatement.execute();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
