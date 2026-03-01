package com.contactsapp;

public class Contact {

    private String contactName;
    private String phoneNumber;

    public Contact(String contactName, String phoneNumber) {

        if (contactName == null || contactName.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact name cannot be empty.");
        }

        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be 10 digits.");
        }

        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
