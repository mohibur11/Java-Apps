package service;


import dao.AccountDAO;
import model.Account;

import java.sql.SQLException;

public class AccountService {
    private AccountDAO accountDAO;

    // Setter for dependency injection
    public void setAccountDao(AccountDAO accountDao) {
        this.accountDAO = accountDao;
    }

    public Account getAccount(String accountId) {
        Account account = accountDAO.getAccount(accountId);
        if (account != null) {
            return account;
        }
        throw new IllegalArgumentException("Account not found for ID: " + accountId);
    }

    public void createAccount(Account account) {
        accountDAO.saveAccount(account);
    }

    public void deposit(String id, Double amount) throws SQLException {
        Account currentAccount = accountDAO.getAccount(id);
        if (currentAccount == null) {
            return;
        }
        currentAccount.setBalance(currentAccount.getBalance() + amount);
        accountDAO.updateAccount(currentAccount);
    }

    public void withdraw(String id, Double withdrawAmount) throws SQLException {
        Account currentAccount = accountDAO.getAccount(id);
        if (currentAccount == null) {
            return;
        }
        Double currentAccountBalance = currentAccount.getBalance();
        if (currentAccountBalance < withdrawAmount) {
            System.out.println("Not sufficient Amount, Your Current balance is " + currentAccountBalance);
            return;
        }
        currentAccount.setBalance(currentAccount.getBalance() - withdrawAmount);
        accountDAO.updateAccount(currentAccount);
    }
}
