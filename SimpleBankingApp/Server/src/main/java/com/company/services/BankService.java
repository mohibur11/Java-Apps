// File: src/main/java/com/company/services/BankService.java
package com.company.services;

import com.company.models.Account;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {
    private Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String accountId, String holderName, double initialBalance) {
        Account account = new Account(accountId, holderName, initialBalance);
        accounts.put(accountId, account);
        System.out.println("Account created for " + holderName + " with ID: " + accountId);
        return account;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void depositToAccount(String accountId, double amount) {
        Account account = getAccount(accountId);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawFromAccount(String accountId, double amount) {
        Account account = getAccount(accountId);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
}
