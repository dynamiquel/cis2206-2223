package Practical_17;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, PhoneBookEntry> entries;

    public PhoneBook() {
        entries = new HashMap<>(10);
    }

    public boolean insertOrUpdate(PhoneBookEntry entry) {
        // Do not allow an invalid entry to be inserted.
        if (entry == null || !entry.isValid())
            return false;

        entries.put(entry.getFullName(), entry);
        return true;
    }

    public boolean delete(String fullName) {
        return entries.remove(fullName) != null;
    }

    public PhoneBookEntry get(String fullName) {
        return entries.get(fullName);
    }

    public boolean contains(String fullName) {
        return entries.containsKey(fullName);
    }

    public void printEntry(String fullName) {
        if (contains(fullName))
            System.out.println(get(fullName));
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return entries.values().toString();
    }
}
