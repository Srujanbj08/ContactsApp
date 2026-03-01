package com.contactsapp;

import java.util.List;

public interface ContactFilter {

    List<Contact> filter(List<Contact> contacts);
}