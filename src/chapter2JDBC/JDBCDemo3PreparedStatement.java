package chapter2JDBC;

import java.sql.*;

public class JDBCDemo3PreparedStatement {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement statement = conn.prepareStatement("select id, grade, name, gender from students where gender = ? and grade = ?");
        statement.setObject(1, 1); //注意：索引从1开始
        statement.setObject(2, 3); //注意：索引从1开始

        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            long id = rs.getLong("id");
            long grade = rs.getLong("grade");
            String name = rs.getString("name");
            int gender = rs.getInt("gender");
            System.out.printf("id: %s, grade: %s, name: %s, gender:%s \n", id, grade,name, gender);
        }
        rs.close();
        statement.close();
        conn.close();
    }
}
