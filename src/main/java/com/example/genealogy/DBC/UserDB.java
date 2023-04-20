package com.example.genealogy.DBC;

import com.example.genealogy.bean.User;

import java.sql.*;

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
            PreparedStatement preparedStatement= connection.prepareStatement("update users set statue= '1' where email= ? ");
            preparedStatement.setString(1, email);
            int count=preparedStatement.executeUpdate();
            if (count>0)
                return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
            return false;
    }

    public boolean checkUser(String username, String password) {

        System.out.println("username: " + username);
        String sql = "select count(*) from users where username='" + username + "' and password='" + password + "'";
        try {
            Statement statement = new JDBC().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int count = -1;
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            System.out.println(count);
            if (count > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean IsNameExist(String username){

        try {
            PreparedStatement preparedStatement=new JDBC().getConnection().prepareStatement("select count(*) from users where username=?");
            preparedStatement.setString(1,username);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean IsEmailExist(String email){

        try {
            PreparedStatement preparedStatement=new JDBC().getConnection().prepareStatement("select count(*) from users where username=?");
            preparedStatement.setString(1,email);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void main(String[] args) {
        UserDB userDB=new UserDB();
        boolean a=userDB.IsNameExist("ximeng");
        System.out.println(a);
    }

}
