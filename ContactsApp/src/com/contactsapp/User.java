package com.contactsapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class User {

    // User details
    private String name;
    private String email;
    private String passwordHash;

    // Constructor
    public User(String name, String email, String password) throws NoSuchAlgorithmException {
        setName(name);        // Set name
        setEmail(email);      // Set email
        setPassword(password); // Set password
    }

    // Get name
    public String getName() {
        return name;
    }

    // Get email
    public String getEmail() {
        return email;
    }

    // Get password hash
    public String getPasswordHash() {
        return passwordHash;
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
        this.passwordHash = hashPassword(newPassword); // Hash password
    }

    // Validate Email
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    // Hash Password using SHA-256
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b)); // Convert to hex
        }
        return sb.toString();
    }
}