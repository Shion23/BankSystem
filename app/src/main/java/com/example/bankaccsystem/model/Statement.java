package com.example.bankaccsystem.model;

import java.util.Date;
// each statement is associated with one acc
public class Statement {
    private int statementId;
    private Date date;
    private String content;
    private Account account;

    public Statement(int statementId, Date date, String content, Account account) {
        this.statementId = statementId;
        this.date = date;
        this.content = content;
        this.account = account;
    }

    public int getStatementId() {
        return statementId;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public Account getAccount() {
        return account;
    }
}

