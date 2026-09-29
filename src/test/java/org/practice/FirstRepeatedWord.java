package org.practice;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class FirstRepeatedWord {

    public static String getFirstRepeatedWord(String input) {

        if (input == null) {
            throw new IllegalArgumentException("String is Null");
        }
        String normalizedInput = input.toLowerCase().trim();
        if (normalizedInput.isEmpty()) {
            throw new IllegalArgumentException("String is Empty");
        }
        String[] words = normalizedInput.split("\\s+");

        Set<String> seen = new HashSet<>();
        for (String word : words) {
            if (!seen.add(word)) {
                return word;
            }
        }
        return null;

    }

    @Test
    void shouldReturnRepeatedWord() {
        String input = "this is test this is good";
        String expected = "this";
        String actual = getFirstRepeatedWord(input);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnRepeatedWordNotMostFrequent() {
        String input = "one two two one";
        String expected = "two";
        String actual = getFirstRepeatedWord(input);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnRepeatedWordWithAdditionalSpaces() {
        String input = "  this is test this  is good ";
        String expected = "this";
        String actual = getFirstRepeatedWord(input);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnRepeatedWordWithSpecialCharacterString() {
        String input = "*&*&  is test *&*&  is good";
        String expected = "*&*&";
        String actual = getFirstRepeatedWord(input);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnRepeatedWordWithNumericString() {
        String input = "456  is test 456  is good";
        String expected = "456";
        String actual = getFirstRepeatedWord(input);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullForNonRepeatedWord() {
        String input = "this is test good";
        String actual = getFirstRepeatedWord(input);
        assertNull(actual);
    }

    @Test
    void shouldThrowErrorForNullString() {
        String input = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getFirstRepeatedWord(input));
        assertEquals("String is Null", exception.getMessage());
    }

    @Test
    void shouldThrowErrorForEmptyString() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getFirstRepeatedWord(input));
        assertEquals("String is Empty", exception.getMessage());
    }

    @Test
    void shouldThrowErrorForBlankString() {
        String input = " ";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getFirstRepeatedWord(input));
        assertEquals("String is Empty", exception.getMessage());
    }
}
