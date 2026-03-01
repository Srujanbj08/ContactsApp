package com.contactsapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilterByFrequency implements ContactFilter {

    @Override
    public List<Contact> filter(List<Contact> contacts) {

        List<Contact> result = new ArrayList<>(contacts);

        Collections.sort(result, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return Integer.compare(c2.getContactCount(), c1.getContactCount());
            }
        });

        return result;
    }
}