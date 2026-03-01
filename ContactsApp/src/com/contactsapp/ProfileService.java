package com.contactsapp;

public class ProfileService {

    // Update user name
    public void updateName(User user, String newName) {
        user.setName(newName);
        System.out.println("Name updated successfully.");
    }

    // Update User email
    public void updateEmail(User user, String newEmail) {
        user.setEmail(newEmail);
        System.out.println("Email updated successfully.");
    }

    // Change user password
    public void changePassword(User user, String newPassword) throws Exception {
        user.setPassword(newPassword);
        System.out.println("Password changed successfully.");
    }
}