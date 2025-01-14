package dao;

import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public void saveAccount(Account account) {
        String sql = "INSERT INTO account (pk_user_id, name, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getUser_id());
            stmt.setString(2, account.getName());
            stmt.setString(3, account.getEmail());
            stmt.executeUpdate();
            System.out.println("Account created.");
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate")) {
                System.out.println("Already have an account with this ID, please try with another one");
            }
            e.printStackTrace();
        }
    }

    public Account getAccount(String id) {
        String sql = "SELECT * FROM account WHERE pk_user_id = " + id ;
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                rs.next();
                Account account = new Account(
                        rs.getString("pk_user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("balance")
                );
                return account;

        } catch (Exception e) {
            if (e.getMessage().contains("empty result set")) {
                System.out.println("No Account Found");
            }
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAllAccount() throws SQLException {
        List<Account> tasks = new ArrayList<>();
        String sql = "SELECT * FROM account";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Account task = new Account(
                        rs.getString("pk_user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("balance")
                );
                tasks.add(task);
            }
        }
        return tasks;
    }

    public Boolean updateAccount(Account account) throws SQLException {

        String sql = "UPDATE account SET balance = ? WHERE pk_user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, account.getBalance());
            stmt.setString(2, account.getUser_id());
            stmt.executeUpdate();
            System.out.println("Record updated.");
            return true;
        }
    }
}
