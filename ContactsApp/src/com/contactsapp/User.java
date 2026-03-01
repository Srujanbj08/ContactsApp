package com.contactsapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {

    // User fields
    private String name;
    private String email;
    private String passwordHash;

    // Contact list
    private List<Contact> contacts;

    // Constructor
    public User(String name, String email, String password) throws NoSuchAlgorithmException {
        this.contacts = new ArrayList<>();
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    // Add contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Update name
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    // Update email
    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }

    // Update password
    public void setPassword(String newPassword) throws NoSuchAlgorithmException {
        if (newPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters.");
        }
        this.passwordHash = hashPassword(newPassword);
    }

    // Email validation
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    // Hash password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
 // Find contact by name
    public Contact getContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // Replace old contact with updated contact
    public void updateContact(Contact oldContact, Contact newContact) {
        int index = contacts.indexOf(oldContact);
        if (index != -1) {
            contacts.set(index, newContact);
        }
    }
}