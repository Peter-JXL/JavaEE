package chapter2JDBC;

import java.sql.*;

public class JDBCDemo5Insert2 {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement statement = conn.prepareStatement("insert into students (grade, name, gender, score) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setObject(1, 1); //grade
        statement.setObject(2, "Bob2"); //name
        statement.setObject(3, 1); //gender
        statement.setObject(4, 66); //score

        int n  = statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if(rs.next()){
            long id = rs.getLong(1);
            System.out.println("id: " + id);
        }

        rs.close();
        statement.close();
        conn.close();
    }
}
