package Practical_17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTests {
    @Test
    void VerifyValidInsert() {
        var entry1 = new PhoneBookEntry("Hall", "Liam", "");
        var entry2 = new PhoneBookEntry("Sinal", "Nari", "+447862485764");
        var entry3 = new PhoneBookEntry("Conhee", "Drea", "07538332719");
    }

    @Test
    void VerifyInvalidInsert() {

    }

    @Test
    void VerifyValidModification() {

    }

    @Test
    void VerifyInvalidModification() {

    }

    @Test
    void VerifyDeletion() {

    }
}
