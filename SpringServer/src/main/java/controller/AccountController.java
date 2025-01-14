package controller;

import service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public String createAccount(@RequestParam String username) {
        accountService.createAccount(username);
        return "Account Created";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String username, @RequestParam double amount) {
        accountService.deposit(username, amount);
        return "Deposit Successful";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String username, @RequestParam double amount) {
        accountService.withdraw(username, amount);
        return "Withdraw Successful";
    }

    @GetMapping("/balance")
    public double checkBalance(@RequestParam String username) {
        return accountService.checkBalance(username);
    }
}
