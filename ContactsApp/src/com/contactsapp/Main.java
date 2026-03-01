package com.contactsapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Input object
        Scanner scanner = new Scanner(System.in);

        // Service object
        RegistrationService service = new RegistrationService();

        try {
            // Title
            System.out.println("=== User Registration ===");

            // Get name
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            // Get email
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            // Get password
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Register user
            User user = service.registerUser(name, email, password);

            // Success message
            System.out.println("\nRegistration Successful!");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password Hash: " + user.getPasswordHash());

        } catch (Exception e) {
            // Error message
            System.out.println("Registration Failed: " + e.getMessage());
        }

        // Close input
        scanner.close();
    }
} 
