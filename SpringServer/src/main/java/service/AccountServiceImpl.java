package service;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void createAccount(String username) {
        // Logic for account creation
    }

    @Override
    public void deposit(String username, double amount) {
        // Logic for deposit
    }

    @Override
    public void withdraw(String username, double amount) {
        // Logic for withdrawal
    }

    @Override
    public double checkBalance(String username) {
        // Logic to check balance
        return 0;
    }
}
