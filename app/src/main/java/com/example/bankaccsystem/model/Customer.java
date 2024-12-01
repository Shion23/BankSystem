package com.example.bankaccsystem.model;
//A customer has ony one contact
// A customer has only one address
public class Customer {
    private int customerId;
    private String firstName;
    private String surname;
    private Contact contact;
    private Address address;

    public Customer(int customerId, String firstName, String surname, Contact contact, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.surname = surname;
        this.contact = contact;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
}

