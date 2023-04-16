package com.example.genealogy.DBC;

import java.sql.*;

import static java.lang.Class.forName;

public class Text {
    public static void main(String[] args) {

            String url = "jdbc:mysql://localhost:3306/genealogy"; // 数据库连接URL
            String username = "root"; // 数据库用户名
            String password = "xsl203457"; // 数据库密码

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                int count= stmt.executeUpdate("SELECT Count(*) FROM Users");
                if (count>0)
                    System.out.println(count);

                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

