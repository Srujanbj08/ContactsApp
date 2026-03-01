package com.contactsapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in); // Scanner for input
		List<User> registeredUsers = new ArrayList<>(); // List to store users

		// UC-01 Register
		System.out.println("=== REGISTER FIRST ===");
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();

		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		registeredUsers.add(new User(name, email, password)); // Create user
		System.out.println("Registration Successful!\n");

		// UC-02 Login
		LoginService loginService = new LoginService(registeredUsers); // Login service
		SessionManager session = new SessionManager(); // Session manager

		System.out.println("=== LOGIN ===");
		System.out.print("Enter Email: ");
		String loginEmail = scanner.nextLine();

		System.out.print("Enter Password: ");
		String loginPassword = scanner.nextLine();

		User loggedInUser = loginService.login(loginEmail, loginPassword); // Validate login

		if (loggedInUser != null) {

			session.startSession(loggedInUser); // Start session
			ProfileService profileService = new ProfileService(); // Profile service

			while (true) {

				// Main menu
				System.out.println("\n=== MAIN MENU ===");
				System.out.println("1. Profile Management");
				System.out.println("2. Add Contact");
				System.out.println("3. View Contact");
				System.out.println("4. Edit Contact");
				System.out.println("5. Delete Contact");
				System.out.println("6. Bulk Operations");
				System.out.println("7. Exit");
				System.out.print("Choose option: ");

				int choice = Integer.parseInt(scanner.nextLine());

				// Profile management
				if (choice == 1) {

					while (true) {

						System.out.println("\n=== PROFILE MENU ===");
						System.out.println("1. Update Name");
						System.out.println("2. Update Email");
						System.out.println("3. Change Password");
						System.out.println("4. Back");
						System.out.print("Choose option: ");

						int profileChoice = Integer.parseInt(scanner.nextLine());

						if (profileChoice == 1) {
							System.out.print("Enter New Name: ");
							profileService.updateName(loggedInUser, scanner.nextLine()); // Update name
						}

						else if (profileChoice == 2) {
							System.out.print("Enter New Email: ");
							profileService.updateEmail(loggedInUser, scanner.nextLine()); // Update email
						}

						else if (profileChoice == 3) {
							System.out.print("Enter New Password: ");
							profileService.changePassword(loggedInUser, scanner.nextLine()); // Update password
						}

						else if (profileChoice == 4) {
							break; // Exit profile menu
						}

						else {
							System.out.println("Invalid Option!");
						}
					}
				}

				// Create contact
				else if (choice == 2) {

					try {
						System.out.print("Enter Contact Name: ");
						String cname = scanner.nextLine();

						System.out.print("Enter Phone Number: ");
						String phone = scanner.nextLine();

						loggedInUser.addContact(new Contact(cname, phone)); // Add contact
						System.out.println("Contact Added Successfully!");

					} catch (IllegalArgumentException e) {
						System.out.println("Error: " + e.getMessage()); // Validation error
					}
				}
				// View specific contact
				else if (choice == 3) {

					System.out.print("Enter Contact Name to View: ");
					String searchName = scanner.nextLine();

					Contact contact = loggedInUser.getContactByName(searchName);

					if (contact != null) {
						System.out.println("\nContact Details:");
						System.out.println(contact); // Uses toString()
					} else {
						System.out.println("Contact not found.");
					}
				}
				// Edit Contact
				else if (choice == 4) {

					System.out.print("Enter Contact Name to Edit: ");
					String searchName = scanner.nextLine();

					Contact existing = loggedInUser.getContactByName(searchName);

					if (existing != null) {

						try {
							System.out.print("Enter New Contact Name: ");
							String newName = scanner.nextLine();

							System.out.print("Enter New Phone Number: ");
							String newPhone = scanner.nextLine();

							// Create updated copy
							Contact updatedContact = new Contact(existing);
							updatedContact.setContactName(newName);
							updatedContact.setPhoneNumber(newPhone);

							loggedInUser.updateContact(existing, updatedContact);

							System.out.println("Contact Updated Successfully!");

						} catch (IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
						}

					} else {
						System.out.println("Contact not found.");
					}
				}
				// Delete Contact
				else if (choice == 5) {

					System.out.print("Enter Contact Name to Delete: ");
					String searchName = scanner.nextLine();

					Contact contact = loggedInUser.getContactByName(searchName);

					if (contact != null) {

						System.out.print("Are you sure you want to delete this contact? (yes/no): ");
						String confirm = scanner.nextLine();

						if (confirm.equalsIgnoreCase("yes")) {

							boolean removed = loggedInUser.deleteContact(contact);

							if (removed) {
								System.out.println("Contact deleted successfully.");
							} else {
								System.out.println("Deletion failed.");
							}

						} else {
							System.out.println("Deletion cancelled.");
						}

					} else {
						System.out.println("Contact not found.");
					}
				}
				else if (choice == 6) {

					System.out.println("1. Bulk Delete");
					System.out.println("2. Bulk Tag");
					System.out.println("3. Export Contacts");
					System.out.print("Choose option: ");

					int bulkChoice = Integer.parseInt(scanner.nextLine());

					// Bulk Delete
					if (bulkChoice == 1) {

						System.out.print("Enter contact names separated by comma: ");
						String input = scanner.nextLine();
						List<String> names = List.of(input.split(","));

						loggedInUser.bulkDelete(names);
						System.out.println("Selected contacts deleted.");
					}

					// Bulk Tag
					else if (bulkChoice == 2) {

						System.out.print("Enter contact names separated by comma: ");
						String input = scanner.nextLine();
						List<String> names = List.of(input.split(","));

						System.out.print("Enter tag: ");
						String tag = scanner.nextLine();

						loggedInUser.bulkTag(names, tag);
						System.out.println("Tag added to selected contacts.");
					}

					// Export Contacts
					else if (bulkChoice == 3) {

						try (java.io.FileWriter writer =
								new java.io.FileWriter("contacts_export.txt")) {

							for (Contact contact : loggedInUser.getContacts()) {
								writer.write(contact.toString());
								writer.write("\n");
							}

							System.out.println("Contacts exported to contacts_export.txt");

						} catch (Exception e) {
							System.out.println("Export failed: " + e.getMessage());
						}
					}
				}

				else if (choice == 7) {
					break; // Exit application
				}

				else {
					System.out.println("Invalid Option!");
				}
			}

		} else {
			System.out.println("Invalid Email or Password!"); // Login failed
		}

		scanner.close(); // Close scanner
	}
}