package com.example.bankaccsystem.model;

//many acc to 1 bank
//an acc can have multiple owners (joint account) and a customer can own multiple acc
//An acc can have multiple statement
public abstract class Account {
    protected int accountId;
    protected double balance;
    protected double interestRate;
    protected String interestPeriod;

    public Account(int accountId, double balance, double interestRate, String interestPeriod) {
        this.accountId = accountId;
        this.balance = balance;
        this.interestRate = interestRate;
        this.interestPeriod = interestPeriod;
    }

    public abstract boolean deposit(double amount);
    public abstract boolean withdraw(double amount);

    public int getAccountId() {

        return accountId;
    }

    public double getBalance() {

        return balance;
    }

    public double getInterestRate() {

        return interestRate;
    }

    public String getInterestPeriod() {

        return interestPeriod;
    }
}

