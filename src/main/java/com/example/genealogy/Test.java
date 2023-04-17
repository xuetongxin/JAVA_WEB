package com.example.genealogy;
import com.example.genealogy.DBC.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String username = "123456";
        String password = "123456";
        String sql = "select count(*) from users where username='" + username + "' and password='" + password + "'";
        try {
            Statement statement = new JDBC().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int count = -1;
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}