package com.example.genealogy.DBC;

import java.sql.*;

public class JDBC {
    String url=null;
    String name=null;
    String passwords=null;
    String driver=null;
    public JDBC(){
        this.url="jdbc:mysql://localhost:3306/genealogy";
        this.name="root";
        this.passwords="xsl203457";
        this.driver="com.mysql.cj.jdbc.Driver";
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url,name,passwords);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if(connection!=null){
            connection.close();
        }
    }

    public void closeConnection(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
        if(connection!=null)
            connection.close();
        if (preparedStatement!=null)
            preparedStatement.close();
        if (resultSet!=null)
            resultSet.close();
    }

}
