package chapter2JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo8Transaction {
    public static void main(String[] args) throws Exception {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement statement = null;
        try {
            conn.setAutoCommit(false);
            statement = conn.prepareStatement("insert into students (id, grade, name, gender, score) values (?,?,?,?,?)");
            statement.setObject(1, 999); //id, 注意：索引从1开始
            statement.setObject(2, 1); //grade
            statement.setObject(3, "Bob"); //name
            statement.setObject(4, 1); //gender
            statement.setObject(5, 6); //score
            statement.executeUpdate();

            statement = conn.prepareStatement("delete from students where id in (?)" );
            statement.setObject(1, 999); // 注意：索引从1开始
            statement.executeUpdate(); // 返回删除的行数

            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            conn.setAutoCommit(true);
            statement.close();
            conn.close();
        }

    }
}
