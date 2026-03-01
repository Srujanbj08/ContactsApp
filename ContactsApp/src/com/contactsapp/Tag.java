package com.contactsapp;

import java.util.Objects;

public class Tag {

    private String name;

    public Tag(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tag name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    // Two tags are equal if their names are equal (case-insensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tag)) return false;

        Tag other = (Tag) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return name;
    }
}