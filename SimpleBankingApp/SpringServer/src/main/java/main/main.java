package main;


import model.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

import java.sql.SQLException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Load Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // Get AccountService bean
        AccountService accountService = context.getBean("accountService", AccountService.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Create Account");
            System.out.println("2. Get Account");
            System.out.println("3. Deposit to Account");
            System.out.println("4. Withdraw From Account");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account id: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Account name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Account email: ");
                        String email = scanner.nextLine();

                        Account newAccount = new Account(id, name, email, 0D);
                        accountService.createAccount(newAccount);
                        break;

                    case 2:
                        System.out.print("Enter Account id: ");
                        String user_id = scanner.nextLine();
                        Account account = accountService.getAccount(user_id);
                        System.out.println(account);
                        break;

                    case 3:
                        System.out.print("Enter account ID to deposit: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Enter Deposit Amount ");
                        Double depositAmount = scanner.nextDouble();
                        accountService.deposit(updateId, depositAmount);
                        break;

                    case 4:
                        System.out.print("Enter account ID to withdraw: ");
                        String withdrawAccountId = scanner.nextLine();
                        System.out.print("Enter withdraw Amount ");
                        Double withdrawAmount = scanner.nextDouble();
                        accountService.withdraw(withdrawAccountId, withdrawAmount);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e + e.getMessage());
            }
        }
    }
}
