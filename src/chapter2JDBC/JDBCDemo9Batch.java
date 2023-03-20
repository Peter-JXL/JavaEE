package chapter2JDBC;

import java.sql.*;

public class JDBCDemo9Batch {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement statement = conn.prepareStatement("insert into students (grade, name, gender, score) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < 10; i++) {
            statement.setObject(1, 1); //grade
            statement.setObject(2, "Bob"); //name
            statement.setObject(3, 1); //gender
            statement.setObject(4, 6); //score
            statement.addBatch();
        }

        int[] numarray = statement.executeBatch();
        for (int n : numarray) {
            System.out.println(n + " inserted. ");
        }
        statement.close();
        conn.close();
    }
}
