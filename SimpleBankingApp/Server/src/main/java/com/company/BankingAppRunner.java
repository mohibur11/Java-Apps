// File: src/main/java/com/company/BankingAppRunner.java
package com.company;

import com.company.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BankingAppRunner implements CommandLineRunner {

    private final BankService bankService;

    public BankingAppRunner(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nBanking App Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account ID: ");
                    String accountId = scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String holderName = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    bankService.createAccount(accountId, holderName, balance);
                    break;
                case 2:
                    System.out.print("Enter Account ID: ");
                    accountId = scanner.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankService.depositToAccount(accountId, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Account ID: ");
                    accountId = scanner.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankService.withdrawFromAccount(accountId, withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter Account ID: ");
                    accountId = scanner.nextLine();
                    double currentBalance = bankService.getAccount(accountId).getBalance();
                    System.out.println("Current Balance: $" + currentBalance);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Banking App!");
    }
}
