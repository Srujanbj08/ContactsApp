package com.contactsapp;

public class SessionManager {

    // Stores logged-in user
    private User currentUser;

    // Start session
    public void startSession(User user) {
        this.currentUser = user;
        System.out.println("Login Successful! Welcome " + user.getName());
    }

    // Check login status
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    // Get Current user
    public User getCurrentUser() {
        return currentUser;
    }

    // Logout user
    public void logout() {
        currentUser = null;
    }
}