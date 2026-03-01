package com.contactsapp;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

public class Contact {
	private LocalDateTime dateAdded;
	private int contactCount;

	private String contactName;
	private String phoneNumber;

	// Constructor
	public Contact(String contactName, String phoneNumber) {
		setContactName(contactName);
		setPhoneNumber(phoneNumber);
		this.dateAdded = LocalDateTime.now(); // Track creation time
		this.contactCount = 0; // Initial frequency
	}

	// Copy constructor
	public Contact(Contact other) {
		this.contactName = other.contactName;
		this.phoneNumber = other.phoneNumber;
	}

	// Getter methods
	public String getContactName() {
		return contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// Setter with validation
	public void setContactName(String contactName) {
		if (contactName == null || contactName.trim().isEmpty()) {
			throw new IllegalArgumentException("Contact name cannot be empty.");
		}
		this.contactName = contactName;
	}

	// Setter with validation
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone number must be 10 digits.");
		}
		this.phoneNumber = phoneNumber;
	}
	private Set<String> tags = new HashSet<>();

	// Add tag
	public void addTag(String tag) {
		if (tag != null && !tag.trim().isEmpty()) {
			tags.add(tag);
		}
	}

	// Get tags
	public Set<String> getTags() {
		return new HashSet<>(tags);
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public int getContactCount() {
		return contactCount;
	}

	public void incrementContactCount() {
		contactCount++;
	}

	@Override
	public String toString() {
		return "Name: " + contactName +
				", Phone: " + phoneNumber +
				", Tags: " + tags;
	}
}