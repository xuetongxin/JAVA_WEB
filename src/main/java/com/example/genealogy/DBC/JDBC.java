package com.example.genealogy.DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    String url=null;
    String name=null;
    String password=null;
    String driver=null;
    JDBC(){
        this.url="jdbc:mysql://localhost:3306/genealogy";
        this.name="root";
        this.password="xsl20457";
        this.driver="com.mysql.cj.jdbc.Driver";
    }
    Connection getConnection() throws SQLException {
        Connection connection=null;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,name,password);
            if(!connection.isClosed()){
                System.out.println("数据库连接成功");
            }else
                System.out.println("连接失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (connection != null)
            return connection;
        else {
            System.out.println("NULL");
            return null;
        }
    }

    public static void main(String[] args) {
        String username="123456";
        String password="123456";
        JDBC jdbc=new JDBC();

        try {
            String sql="select count(*) from user where username='"+username+"' and password='"+password+"'";
            try {
                    Statement statement=jdbc.getConnection().createStatement();
                    int count=statement.executeUpdate(sql);
                    if(count>0){
                        System.out.println("登录成功");
                    }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
