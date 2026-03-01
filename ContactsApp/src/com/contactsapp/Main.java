package com.contactsapp;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        // List to store users
        List<User> registeredUsers = new ArrayList<>();

        // Registration (UC-01)
        System.out.println("=== REGISTER FIRST ===");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Add new user
        registeredUsers.add(new User(name, email, password));
        System.out.println("Registration Successful!\n");

        // Login (UC-02)
        LoginService loginService = new LoginService(registeredUsers);
        SessionManager session = new SessionManager();

        System.out.println("=== LOGIN ===");
        System.out.print("Enter Email: ");
        String loginEmail = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        // Check login
        User loggedInUser = loginService.login(loginEmail, loginPassword);

        if (loggedInUser != null) {
            session.startSession(loggedInUser); // Start session
        } else {
            System.out.println("Invalid Email or Password!"); // Error message
        }

        // Close scanner
        scanner.close();
    }
}