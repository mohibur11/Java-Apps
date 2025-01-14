package com.mohibur.Jspdemo.controller;

import com.mohibur.Jspdemo.entity.Account;
import com.mohibur.Jspdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("account", new Account());
        return "createAccount";
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute Account account, Model model) {
        Account savedAccount = accountService.createAccount(account);
        model.addAttribute("account", savedAccount);
        return "confirmation";
    }

    @GetMapping("/search")
    public String searchForm() {
        return "searchAccount";
    }

    @PostMapping("/search")
    public String searchAccount(@RequestParam String id, Model model) {
        try {
            Account account = accountService.getAccountById(id).orElseThrow(() -> new Exception("Account not found"));
            model.addAttribute("account", account);
            return "confirmation";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/deposit")
    public String depositForm() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String id, @RequestParam Double amount, Model model) {
        try {
            Account account = accountService.deposit(id, amount);
            model.addAttribute("account", account);
            return "confirmation";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/withdraw")
    public String withdrawForm() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String id, @RequestParam Double amount, Model model) {
        try {
            Account account = accountService.withdraw(id, amount);
            model.addAttribute("account", account);
            return "confirmation";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteAccount() {
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteAccount(@RequestParam String id, Model model) {
        try {
            Account account = accountService.getAccountById(id).orElseThrow(() -> new Exception("Account Not Exist"));
            if (account != null) {
                accountService.deleteAccount(id);
                model.addAttribute(account);
            }
            return "confirmation";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

}
