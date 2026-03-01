package com.contactsapp;

import java.util.ArrayList;
import java.util.List;

public class SearchByTag implements ContactSearch {

    @Override
    public List<Contact> search(List<Contact> contacts, String keyword) {

        List<Contact> result = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getTags().contains(keyword)) {
                result.add(contact);
            }
        }

        return result;
    }
}