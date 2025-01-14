package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/simple_banking";
    private static final String USER = "root";
    private static final String PASSWORD = "Enosis123@";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    URL, USER,
                    PASSWORD);
            System.out.println("Connection established.");
            return con;
        }
        catch (Exception e) {
            System.out.println("Connection established failed.");
            e.printStackTrace();
            return null;
        }
    }
}
