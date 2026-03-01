package com.contactsapp;

import java.util.List;

public interface ContactSearch {

    List<Contact> search(List<Contact> contacts, String keyword);
}