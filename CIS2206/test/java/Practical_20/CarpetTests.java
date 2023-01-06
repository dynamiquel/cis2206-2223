package Practical_20;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarpetTests {
    @Test
    void Carpet3x3() throws IOException, SierpinskiCarpet.InvalidBoardSizeException {
        // Need to remove whitespace from both the strings as the test cases have inconsistent file endings.
        var validCarpet = Files.readString(Path.of("test/resources/Sierpinski_Carpet_3.txt")).trim();

        var carpet = new SierpinskiCarpet(3);
        assertEquals(validCarpet, carpet.toString().trim());
    }

    @Test
    void Carpet9x9() throws IOException, SierpinskiCarpet.InvalidBoardSizeException {
        var validCarpet = Files.readString(Path.of("test/resources/Sierpinski_Carpet_9.txt")).trim();

        var carpet = new SierpinskiCarpet(9);
        assertEquals(validCarpet, carpet.toString().trim());
    }

    @Test
    void Carpet27x27() throws IOException, SierpinskiCarpet.InvalidBoardSizeException {
        var validCarpet = Files.readString(Path.of("test/resources/Sierpinski_Carpet_27.txt")).trim();

        var carpet = new SierpinskiCarpet(27);
        assertEquals(validCarpet, carpet.toString().trim());
    }

    @Test
    void Carpet81x81() throws IOException, SierpinskiCarpet.InvalidBoardSizeException {
        var validCarpet = Files.readString(Path.of("test/resources/Sierpinski_Carpet_81.txt")).trim();

        var carpet = new SierpinskiCarpet(81);
        assertEquals(validCarpet, carpet.toString().trim());
    }

    @Test
    void Carpet243x243() throws IOException, SierpinskiCarpet.InvalidBoardSizeException {
        var validCarpet = Files.readString(Path.of("test/resources/Sierpinski_Carpet_243.txt")).trim();

        var carpet = new SierpinskiCarpet(243);
        assertEquals(validCarpet, carpet.toString().trim());
    }

    @Test
    void Carpet8x8() throws IOException, SierpinskiCarpet.InvalidBoardSizeException {
        var validCarpet = Files.readString(Path.of("test/resources/Sierpinski_Carpet_9.txt")).trim();

        boolean exception = false;
        try {
            var carpet = new SierpinskiCarpet(8);
        }
        catch (SierpinskiCarpet.InvalidBoardSizeException e) {
            exception = true;
        }
        assertTrue(exception);
    }
}
