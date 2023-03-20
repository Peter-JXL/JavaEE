package chapter2JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo7Delete {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement statement = conn.prepareStatement("delete from students where id in (?, ?)" );
        statement.setObject(1, 1000); // 注意：索引从1开始
        statement.setObject(2, 999);
        int n  = statement.executeUpdate(); // 返回删除的行数
        System.out.println("n: " + n);

        statement.close();
        conn.close();
    }
}
