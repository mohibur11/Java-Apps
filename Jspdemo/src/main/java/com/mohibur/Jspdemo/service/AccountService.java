package com.mohibur.Jspdemo.service;


import com.mohibur.Jspdemo.entity.Account;
import com.mohibur.Jspdemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(String id) {
        Optional<Account> account = accountRepository.findById(id);
        System.out.println(account);
        return account;
    }

    public Account deposit(String id, Double amount) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(String id, Double amount) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
        if (account.getBalance() < amount) throw new Exception("Insufficient funds");
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

//    private AccountDAO accountDAO = new AccountDAO();
//
//    public double getBalance(String accountId) {
//        Account account = accountDAO.getAccount(accountId);
//        if (account != null) {
//            return account.getBalance();
//        }
//        throw new IllegalArgumentException("Account not found for ID: " + accountId);
//    }
//
//    public void createAccount(Account account) {
//        accountDAO.saveAccount(account);
//    }
//
//    public void deposit(String id, Double amount) throws SQLException {
//        Account currentAccount = accountDAO.getAccount(id);
//        if (currentAccount == null) {
//            return;
//        }
//        currentAccount.setBalance(currentAccount.getBalance() + amount);
//        accountDAO.updateAccount(currentAccount);
//    }
//
//    public void withdraw(String id, Double withdrawAmount) throws SQLException {
//        Account currentAccount = accountDAO.getAccount(id);
//        if (currentAccount == null) {
//            return;
//        }
//        Double currentAccountBalance = currentAccount.getBalance();
//        if (currentAccountBalance < withdrawAmount) {
//            System.out.println("Not sufficient Amount, Your Current balance is " + currentAccountBalance);
//            return;
//        }
//        currentAccount.setBalance(currentAccount.getBalance() - withdrawAmount);
//        accountDAO.updateAccount(currentAccount);
//    }
}
