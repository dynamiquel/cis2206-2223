package Practical_17;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookEntryTests {
    static PhoneBookEntry entry;

    @BeforeAll
    static void BeforeAll() {
        entry = new PhoneBookEntry(
                "Conhee",
                "Drea",
                "07538332719",
                "andreaconhee@hotmail.co.uk",
                "41a, HD3 2EU");
    }

    @Test
    void VerifyName() {
        assertEquals("Drea Conhee", entry.getFullName());
    }

    @Test
    void VerifyPhoneNumber() {
        assertEquals("07538332719", entry.getPhoneNumber());
    }

    @Test
    void VerifyEmailAddress() {
        assertEquals("andreaconhee@hotmail.co.uk", entry.getEmailAddress());
    }

    @Test
    void VerifyHomeAddress() {
        assertEquals("41a, HD3 2EU", entry.getHomeAddress());
    }
}
