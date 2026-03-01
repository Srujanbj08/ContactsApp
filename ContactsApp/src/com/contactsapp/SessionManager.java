package com.contactsapp;

public class SessionManager {

    // Stores current logged-in user
    private User currentUser;

    // Start user session
    public void startSession(User user) {
        currentUser = user;
        System.out.println("Login Successful! Welcome " + user.getName());
    }

    // Check if user is logged in
    public boolean isLoggedIn() {
        return currentUser != null;
    }
}