package chapter2JDBC;

import java.sql.*;

public class JDBCDemo2Select {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select id, grade, name, gender from students where gender = 1");
        while (rs.next()){
            long id = rs.getLong(1); //注意：索引从1开始
            long grade = rs.getLong(2);
            String name = rs.getString(3);
            int gender = rs.getInt(4);
            System.out.printf("id: %s, grade: %s, name: %s, gender:%s \n", id, grade,name, gender);
        }
        rs.close();
        statement.close();
        conn.close();
    }
}
