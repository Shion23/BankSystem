package com.example.bankaccsystem;

public class SavingAccount extends BankAccount {
    //minimum threshold
    private static final double MIN_BALANCE = 100.0;
    //encourage creativity
    private double interestRate;

    public SavingAccount(String accountHolder, double initialBalance, String accountId, double interestRate) {
        super(accountHolder, initialBalance, accountId);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount >= MIN_BALANCE) {
            balance -= amount;
            logTransaction("SavingAccountWithdraw: $" + amount + " | Balance: $" + balance);
            return true;
        } else {
            logTransaction("Failed withdrawal of $" + amount + " | Balance below minimum threshold: $" + getBalance());
            return false;
        }
    }

    @Override
    public boolean transfer(BankAccount destination, double amount) {
        if (withdraw(amount)) {
            destination.deposit(amount);
            logTransaction("SavingAccountTransferred $" + amount + " to " + destination.accountHolder);
            return true;
        }
        return false;
    }


    @Override
    public String getAccountDetails() {
        return super.getAccountDetails() ;
    }

}

