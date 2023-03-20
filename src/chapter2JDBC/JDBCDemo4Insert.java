package chapter2JDBC;

import java.sql.*;

public class JDBCDemo4Insert {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement statement = conn.prepareStatement("insert into students (id, grade, name, gender, score) values (?,?,?,?,?)");
        statement.setObject(1, 999); //id, 注意：索引从1开始
        statement.setObject(2, 1); //grade
        statement.setObject(3, "Bob"); //name
        statement.setObject(4, 1); //gender
        statement.setObject(5, 6); //score

        int n  = statement.executeUpdate();
        if ( 1 != n){
            System.out.println("insert failed!");
        }else {
            System.out.println("insert success!");
        }
        statement.close();
        conn.close();
    }
}
