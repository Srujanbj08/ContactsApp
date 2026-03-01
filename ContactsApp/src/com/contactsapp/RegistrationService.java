package com.contactsapp;

import java.util.regex.Pattern;

public class RegistrationService {

    public User registerUser(String name, String email, String password) throws Exception {

        // Check email format
        if (!isValidEmail(email)) {
            throw new Exception("Invalid Email Format!");
        }

        // Check password length
        if (!isValidPassword(password)) {
            throw new Exception("Password must be at least 6 characters.");
        }

        // Create and return new user
        return new User(name, email, password);
    }

    // Email validation method
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    // Password validation method
    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
}