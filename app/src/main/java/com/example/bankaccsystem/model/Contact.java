package com.example.bankaccsystem.model;

public class Contact {
    private int contactId;
    private String phoneNumber;
    private String mobile;
    private String email;

    public Contact(int contactId, String phoneNumber, String mobile, String email) {
        this.contactId = contactId;
        this.phoneNumber = phoneNumber;
        this.mobile = mobile;
        this.email = email;
    }

    public int getContactId() {
        return contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}
