package com.example.bankaccsystem;

//base class
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BankAccount {
    //protected
    protected String accountHolder;
    protected double balance;
    //private
    private List<String> transactionLog = new ArrayList<>();
    private Date creationDate;
    private String accountId;


    //constructor
    public BankAccount(String accountHolder, double initialBalance, String accountId) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountId = accountId;
        this.creationDate = new Date();
        logTransaction("SINI Account created with initial balance: $" + initialBalance);
    }


//core
    public void deposit(double amount) {
        balance += amount;
        logTransaction("SINI Deposited: $" + amount + " | Balance: $" + balance);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) { //if balance ok
            balance -= amount;
            logTransaction("SINI Withdrew: $" + amount + " | Balance: $" + balance);
            return true;
        } else { //if balance not ok
            logTransaction("SINI Attempted withdrawal of $" + amount + " | Insufficient funds");
            return false;
        }
    }

    public double getBalance() {

        return balance;
    }



    //additional
    protected void logTransaction(String message) {
        transactionLog.add(new Date() + ": " + message);
    }

    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        for (String log : transactionLog) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }


    public boolean transfer(BankAccount destination, double amount) {
        if (this.withdraw(amount)) {
            destination.deposit(amount);
            logTransaction("SINI Transferred $" + amount + " to " + destination.getAccountHolder());
            destination.logTransaction("Received $" + amount + " from " + this.getAccountHolder());
            return true;
        }
        return false;
    }


    public String getAccountHolder() {

        return accountHolder;
    }

    public String getAccountDetails() {
        return String.format("SINI Account ID: %s\nHolder: %s\nBalance: $%.2f", accountId, getAccountHolder(), balance);
    }





}
