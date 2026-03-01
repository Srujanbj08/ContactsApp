package com.contactsapp;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

public class Contact {

	private LocalDateTime dateAdded;
	private int contactCount;
	private String contactName;
	private String phoneNumber;

	private Set<Tag> tags = new HashSet<>();  // Keep only this one

	// Constructor
	public Contact(String contactName, String phoneNumber) {
		setContactName(contactName);
		setPhoneNumber(phoneNumber);
		this.dateAdded = LocalDateTime.now();
		this.contactCount = 0;
	}

	// Copy constructor
	public Contact(Contact other) {
		this.contactName = other.contactName;
		this.phoneNumber = other.phoneNumber;
		this.dateAdded = other.dateAdded;
		this.contactCount = other.contactCount;
		this.tags = new HashSet<>(other.tags);
	}

	// Getter methods
	public String getContactName() {
		return contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public int getContactCount() {
		return contactCount;
	}

	// Setter with validation
	public void setContactName(String contactName) {
		if (contactName == null || contactName.trim().isEmpty()) {
			throw new IllegalArgumentException("Contact name cannot be empty.");
		}
		this.contactName = contactName;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone number must be 10 digits.");
		}
		this.phoneNumber = phoneNumber;
	}

	// Add tag
	public void addTag(Tag tag) {
	    if (tag != null) {
	        tags.add(tag);
	    }
	}

	// Remove tag
	public void removeTag(Tag tag) {
	    tags.remove(tag);
	}

	// Get tags
	public Set<Tag> getTags() {
	    return new HashSet<>(tags);
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