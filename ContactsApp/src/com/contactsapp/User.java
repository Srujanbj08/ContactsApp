package com.contactsapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class User {

	private String name;
	private String email;
	private String passwordHash;

	private List<Contact> contacts;

	// Store unique user tags
	private Set<Tag> userTags = new HashSet<>();

	public User(String name, String email, String password)
			throws NoSuchAlgorithmException {

		this.contacts = new ArrayList<>();
		setName(name);
		setEmail(email);
		setPassword(password);
	}

	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPasswordHash() { return passwordHash; }
	public List<Contact> getContacts() { return contacts; }

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	// CREATE TAG
	public Tag createTag(String tagName) {
		Tag tag = new Tag(tagName);
		userTags.add(tag);   // Set ensures uniqueness
		return tag;
	}

	//  GET ALL TAGS
	public Set<Tag> getUserTags() {
		return new HashSet<>(userTags); // defensive copy
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty())
			throw new IllegalArgumentException("Name cannot be empty.");
		this.name = name;
	}

	public void setEmail(String email) {
		if (!isValidEmail(email))
			throw new IllegalArgumentException("Invalid email format.");
		this.email = email;
	}

	public void setPassword(String newPassword)
			throws NoSuchAlgorithmException {

		if (newPassword.length() < 6)
			throw new IllegalArgumentException("Password must be at least 6 characters.");

		this.passwordHash = hashPassword(newPassword);
	}

	private boolean isValidEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		return Pattern.matches(regex, email);
	}

	private String hashPassword(String password)
			throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = md.digest(password.getBytes());

		StringBuilder sb = new StringBuilder();
		for (byte b : hashBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	public Contact getContactByName(String name) {
		for (Contact c : contacts) {
			if (c.getContactName().equalsIgnoreCase(name))
				return c;
		}
		return null;
	}

	public void updateContact(Contact oldContact, Contact newContact) {
		int index = contacts.indexOf(oldContact);
		if (index != -1) {
			contacts.set(index, newContact);
		}
	}

	public boolean deleteContact(Contact contact) {
		return contacts.remove(contact);
	}

	public void bulkDelete(List<String> names) {
		contacts.removeIf(c ->
			names.contains(c.getContactName()));
	}

	public void bulkTag(List<String> names, Tag tag) {
		for (Contact c : contacts) {
			if (names.contains(c.getContactName())) {
				c.addTag(tag);
			}
		}
	}
}