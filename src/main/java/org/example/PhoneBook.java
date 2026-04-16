package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add (String lastName, String phone) {
        if (! phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phone);
    }
    public List<String> get(String lastName) {
        if (!phoneBook.containsKey(lastName)) {
            return new ArrayList<>();
        }
        return phoneBook.get(lastName);
    }
}
