package com.example.bankaccsystem;
//new class
public class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    public CheckingAccount(String accountHolder, double initialBalance, String accountId, double overdraftLimit) {
        super(accountHolder, initialBalance, accountId);
        this.overdraftLimit = overdraftLimit;
        logTransaction("CheckingAccountOverdraft limit: $" + overdraftLimit);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            logTransaction("CheckingAccountWithdrew with overdraft: $" + amount + " | New Balance: $" + balance);
            return true;
        } else {
            logTransaction("CheckingAccountOverdraft limit reach | Attempted withdrawal of $" + amount + " | Balance: $" + balance);
            return false;
        }
    }

    @Override
    public boolean transfer(BankAccount destination, double amount) {
        if (withdraw(amount)) {
            destination.deposit(amount);
            logTransaction("CheckingAccountTransferred $" + amount + " to " + destination.accountHolder);
            return true;
        }
        return false;
    }
    @Override
    public String getAccountDetails() {
        return super.getAccountDetails() + String.format("\nOverdraft Limit: $%.2f", overdraftLimit);
    }
}


