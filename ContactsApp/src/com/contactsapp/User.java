package com.contactsapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    // Private variables (Encapsulation)
    private String name;
    private String email;
    private String passwordHash;

    // Constructor
    public User(String name, String email, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.email = email;
        this.passwordHash = hashPassword(password); // Hash password
    }

    // Method to hash password using SHA-256
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b)); // Convert to hex
        }
        return sb.toString();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Getter for password hash
    public String getPasswordHash() {
        return passwordHash;
    }
}