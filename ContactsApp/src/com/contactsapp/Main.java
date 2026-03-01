package com.contactsapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        // Input scanner
        Scanner scanner = new Scanner(System.in);

        // Store Registered users
        List<User> registeredUsers = new ArrayList<>();

        // ================= UC-01 REGISTER =================
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

        // ================= UC-02 LOGIN =================
        LoginService loginService = new LoginService(registeredUsers);
        SessionManager session = new SessionManager();

        System.out.println("=== LOGIN ===");
        System.out.print("Enter Email: ");
        String loginEmail = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        // Attempt login
        User loggedInUser = loginService.login(loginEmail, loginPassword);

        if (loggedInUser != null) {

            session.startSession(loggedInUser); // Start session

            // ================= UC-03 PROFILE MANAGEMENT =================
            ProfileService profileService = new ProfileService();

            while (true) {

                // Profile menu
                System.out.println("\n=== PROFILE MENU ===");
                System.out.println("1. Update Name");
                System.out.println("2. Update Email");
                System.out.println("3. Change Password");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    // Update name
                    System.out.print("Enter New Name: ");
                    profileService.updateName(loggedInUser, scanner.nextLine());
                }

                else if (choice == 2) {
                    // Update email
                    System.out.print("Enter New Email: ");
                    profileService.updateEmail(loggedInUser, scanner.nextLine());
                }

                else if (choice == 3) {
                    // Change password
                    System.out.print("Enter New Password: ");
                    profileService.changePassword(loggedInUser, scanner.nextLine());
                }

                else if (choice == 4) {
                    break; // Exit menu
                }

                else {
                    System.out.println("Invalid Option!"); // Invalid choice
                }
            }

        } else {
            System.out.println("Invalid Email or Password!"); // Login failed
        }

        // Close scanner
        scanner.close();
    }
}