package chapter2JDBC;

import java.sql.*;

public class JDBCDemo6Update {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement statement = conn.prepareStatement("update students set name = ? where id = ?" );
        statement.setObject(1, "peterxjl"); // name 注意：索引从1开始
        statement.setObject(2, 999); //id
        int n  = statement.executeUpdate(); // 返回更新的行数
        System.out.println("n: " + n);


        statement.close();
        conn.close();
    }
}
