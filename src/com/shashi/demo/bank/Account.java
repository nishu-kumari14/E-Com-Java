package com.shashi.demo.bank;

/**
 * Account class representing a bank account
 * Contains account details and basic operations
 */
public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    
    /**
     * Constructor to create a new account
     * @param accountNumber Unique account number
     * @param accountHolderName Name of the account holder
     * @param initialBalance Initial deposit amount
     */
    public Account(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
    
    /**
     * Get account number
     * @return account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Get account holder name
     * @return account holder name
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    /**
     * Get current balance
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Deposit money to the account
     * @param amount amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    /**
     * Withdraw money from the account
     * @param amount amount to withdraw
     * @return true if withdrawal successful, false if insufficient funds
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    /**
     * String representation of the account
     * @return formatted account details
     */
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
