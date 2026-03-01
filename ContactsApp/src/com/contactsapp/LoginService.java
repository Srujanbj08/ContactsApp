package com.contactsapp;

import java.security.MessageDigest;
import java.util.List;

public class LoginService {

    // List of registered users
    private List<User> users;

    // Constructor
    public LoginService(List<User> users) {
        this.users = users;
    }

    // Login method
    public User login(String email, String password) throws Exception {

        // Hash entered password
        String hashedInput = hashPassword(password);

        // Check user list
        for (User user : users) {
            if (user.getEmail().equals(email) &&
                user.getPasswordHash().equals(hashedInput)) {
                return user; // Login success
            }
        }

        return null; // Login failed
    }

    // Hash password using SHA-256
    private String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b)); // Convert to hex
        }
        return sb.toString();
    }
}
