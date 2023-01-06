package Practical_17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTests {
    @Test
    void VerifyValidInsert() {
        var entry1 = new PhoneBookEntry("Hall", "Liam", "+44 9322485666");
        var entry2 = new PhoneBookEntry("Sinal", "Nari", "+447862485764");
        var entry3 = new PhoneBookEntry("Conhee", "Drea", "07538332719");

        var phoneBook = new PhoneBook();
        phoneBook.insertOrUpdate(entry1);
        phoneBook.insertOrUpdate(entry2);
        phoneBook.insertOrUpdate(entry3);

        assertTrue(phoneBook.contains("Liam Hall"));
        assertTrue(phoneBook.contains("Nari Sinal"));
        assertTrue(phoneBook.contains("Drea Conhee"));
    }

    @Test
    void VerifyInvalidInsert() {
        var entry1 = new PhoneBookEntry("Hall", "Liam", "not a number");
        var entry2 = new PhoneBookEntry("Sinal", "Nari", "22949319");

        var phoneBook = new PhoneBook();
        phoneBook.insertOrUpdate(entry1);
        phoneBook.insertOrUpdate(entry2);

        assertFalse(phoneBook.contains("Liam Hall"));
        assertFalse(phoneBook.contains("Nari Sinal"));
    }

    @Test
    void VerifyValidModification() {
        var entry1 = new PhoneBookEntry("Hall", "Liam", "+44 9322485666");
        var entry2 = new PhoneBookEntry("Sinal", "Nari", "+447862485764");
        var entry3 = new PhoneBookEntry("Conhee", "Drea", "07538332719");

        var phoneBook = new PhoneBook();
        phoneBook.insertOrUpdate(entry1);
        phoneBook.insertOrUpdate(entry2);
        phoneBook.insertOrUpdate(entry3);

        // Creating a new entry from scratch.
        entry1 = new PhoneBookEntry(entry1.getSurname(), entry1.getForename(), "+44 9367485721");

        // Creating a new entry using the clone method.
        entry2 = entry2.clone("07999538291");
        entry3 = entry3.clone(
                "+447538332719",
                "dreaconhee@outlook.com",
                "41a, HD3 2EU");

        phoneBook.insertOrUpdate(entry1);
        phoneBook.insertOrUpdate(entry2);
        phoneBook.insertOrUpdate(entry3);

        assertEquals("+44 9367485721", phoneBook.get("Liam Hall").getPhoneNumber());
        assertEquals("07999538291", phoneBook.get("Nari Sinal").getPhoneNumber());
        assertEquals("+447538332719", phoneBook.get("Drea Conhee").getPhoneNumber());
        assertEquals("dreaconhee@outlook.com", phoneBook.get("Drea Conhee").getEmailAddress());
    }

    @Test
    void VerifyInvalidModification() {
        var entry1 = new PhoneBookEntry("Hall", "Liam", "+44 9322485666");
        var entry2 = new PhoneBookEntry("Sinal", "Nari", "+447862485764");
        var entry3 = new PhoneBookEntry("Conhee", "Drea", "07538332719");

        var phoneBook = new PhoneBook();
        phoneBook.insertOrUpdate(entry1);
        phoneBook.insertOrUpdate(entry2);
        phoneBook.insertOrUpdate(entry3);

        // Creating a new entry from scratch.
        entry1 = new PhoneBookEntry(entry1.getSurname(), entry1.getForename(), "+lol");

        // Creating a new entry using the clone method.
        entry2 = entry2.clone("7999538291");
        entry3 = entry3.clone(
                "447538332719",
                "dreaconhee@outlook.com",
                "41a, HD3 2EU");

        phoneBook.insertOrUpdate(entry1);
        phoneBook.insertOrUpdate(entry2);
        phoneBook.insertOrUpdate(entry3);

        assertEquals("+44 9322485666", phoneBook.get("Liam Hall").getPhoneNumber());
        assertEquals("+447862485764", phoneBook.get("Nari Sinal").getPhoneNumber());
        assertEquals("07538332719", phoneBook.get("Drea Conhee").getPhoneNumber());
        assertEquals(null, phoneBook.get("Drea Conhee").getEmailAddress());
    }

    @Test
    void VerifyDeletion() {
        var entry1 = new PhoneBookEntry("Hall", "Liam", "+44 9322485666");
        var entry2 = new PhoneBookEntry("Sinal", "Nari", "+447862485764");
        var entry3 = new PhoneBookEntry("Conhee", "Drea", "07538332719");

        var phoneBook = new PhoneBook();
        phoneBook.insertOrUpdate(entry1);
        phoneBook.insertOrUpdate(entry2);
        phoneBook.insertOrUpdate(entry3);

        // Should be true if deletion is successful.
        assertTrue(phoneBook.delete(entry1.getFullName()));
        assertTrue(phoneBook.delete(entry2.getFullName()));
        assertTrue(phoneBook.delete(entry3.getFullName()));

        // Double check the entry no longer exists in the phone book.
        assertFalse(phoneBook.contains(entry1.getFullName()));
        assertFalse(phoneBook.contains(entry2.getFullName()));
        assertFalse(phoneBook.contains(entry3.getFullName()));
    }
}
