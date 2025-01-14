package service;

public interface AccountService {
    void createAccount(String username);
    void deposit(String username, double amount);
    void withdraw(String username, double amount);
    double checkBalance(String username);
}
