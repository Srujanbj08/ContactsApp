📱 MyContacts App

Java Console-Based Contact Management System

📌 Overview

MyContacts App is a Java-based console application developed to demonstrate Object-Oriented Programming (OOP) principles and core Java concepts through a contact management system.

The application supports user management, contact operations, tagging, searching, filtering, and bulk processing.

🚀 Features

👤 User Management

User Registration with email validation

Secure password hashing (SHA-256)

User Login & Profile Management

📇 Contact Management

Add new contacts

View contact details

Edit contact information

Delete contacts (with confirmation)

Bulk delete, bulk tag, export contacts

🏷 Tag Management

Create custom tags

Apply single or multiple tags to contacts

Remove tags from contacts

Unique tag handling using Set

🔎 Search & Filter

Search by name, phone, or tag

Filter by tag, date added, frequently contacted

Sorting using Comparator

🧱 OOP Concepts Used

Encapsulation – Private fields with validation methods

Inheritance – Contact hierarchy (Person / Organization)

Polymorphism – Search and Filter implementations

Abstraction – Interfaces for search and filtering

💻 Core Java Concepts Used

Collections (List, Set)

Streams & Lambda Expressions

LocalDateTime (Date & Time API)

Optional for null handling

UUID for unique IDs

Exception handling

Regular expressions for validation

MessageDigest for password hashing

🔗 Relationships

User manages multiple Contacts

Contact has multiple Tags (many-to-many relationship)

Contact contains PhoneNumber and Email objects

▶️ How to Run

Open project in Eclipse / IntelliJ

Run Main.java

Follow console prompts

🎓 Purpose

This project demonstrates practical implementation of:

Object-Oriented Programming

Java Collections Framework

Modular use-case based development
