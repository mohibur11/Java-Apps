package dao;

import model.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private JdbcTemplate jdbcTemplate;

    // Setter for dependency injection
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveAccount(Account account) {
        String query = "INSERT INTO account (pk_user_id, name, email) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(query, account.getUser_id(), account.getName(), account.getEmail());
            System.out.println("Account created.");
        } catch (Exception e) {
            if (e.getMessage().contains("Duplicate")) {
                System.out.println("Already have an account with this ID, please try with another one");
            }
            e.printStackTrace();
        }
    }

    public Account getAccount(String id) {
        String query = "SELECT * FROM account WHERE pk_user_id = " + id;
        try {
            Object[] args = {id};
            Account account = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Account>(Account.class));
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
