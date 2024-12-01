package com.example.bankaccsystem.model;
//multiple accounts and customers

public class Bank {
    private int bankId;
    private String name;

    public Bank(int bankId, String name) {
        this.bankId = bankId;
        this.name = name;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

