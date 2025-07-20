package com.shashi.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Simple Bank Management System Demo
 * Demonstrates basic banking operations like account creation, deposit, withdrawal, and balance inquiry
 */
public class BankSystem {
    
    private static List<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextAccountNumber = 1001;
    
    public static void main(String[] args) {
        System.out.println("=== Welcome to Bank Management System ===");
        
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    System.out.println("Thank you for using Bank Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
    }
    
    private static void showMenu() {
        System.out.println("\n=== Bank Management System Menu ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        
        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative!");
            return;
        }
        
        Account account = new Account(nextAccountNumber++, name, initialDeposit);
        accounts.add(account);
        
        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Initial Balance: $" + account.getBalance());
    }
    
    private static void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        
        account.deposit(amount);
        System.out.println("Deposit successful!");
        System.out.println("New Balance: $" + account.getBalance());
    }
    
    private static void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
            System.out.println("New Balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    
    private static void checkBalance() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Current Balance: $" + account.getBalance());
    }
    
    private static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        
        System.out.println("\n=== All Accounts ===");
        System.out.printf("%-12s %-20s %-12s%n", "Account No.", "Account Holder", "Balance");
        System.out.println("------------------------------------------------");
        
        for (Account account : accounts) {
            System.out.printf("%-12d %-20s $%-12.2f%n", 
                account.getAccountNumber(), 
                account.getAccountHolderName(), 
                account.getBalance());
        }
    }
    
    private static Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

/**
 * Account class representing a bank account
 */
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    
    public Account(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
