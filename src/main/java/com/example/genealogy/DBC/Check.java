package com.example.genealogy.DBC;

import java.sql.*;

public class Check {

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
            } else
                return false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}

