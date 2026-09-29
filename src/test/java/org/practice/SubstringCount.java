package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class SubstringCount {
    // Time Complexity is O(n*m) as we have to search each substring in String to
    // match the input pattern
    public static int getSubstringCount(String input, String substring) {
        if (input == null || substring == null) {
            throw new IllegalArgumentException("Input or Substring is Null"); // Handle Null String
        }

        if (input.isEmpty() || substring.isEmpty()) {
            throw new IllegalArgumentException("Input or Substring is Empty"); // Handle Empty String
        }

        int count = 0;
        int index = 0;

        // scan through the input String
        while ((index = input.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count; // return count of all cases
    }

    @Test
    void shouldReturnCountForPatternMatching() {
        assertEquals(2, getSubstringCount("java is java", "java"));
    }

    @Test
    void shouldReturnCountZeroForPatternMatching() {
        assertEquals(0, getSubstringCount("java is java", "selenium"));
    }

    @Test
    void shouldReturnCountForPatternMatchingDistinctString() {
        assertEquals(1, getSubstringCount("java is selenium", "java"));
    }

    @Test
    void shouldConsiderCaseSensitivityToMatchPattern() {
        assertEquals(0, getSubstringCount("java is java", "JAVA"));
    }

    @Test
    void shouldReturnPatternCountForStringWithSpaces() {
        assertEquals(2, getSubstringCount("  java    is  java    ", " java   "));
    }

    @Test
    void shouldReturnCountForPatternMatchingWithAlphanumericString() {
        assertEquals(2, getSubstringCount("java is 456GH and java is 456GH", "456GH"));
    }

    @Test
    void shouldThrowErrorForNullStrings() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> getSubstringCount(null, "java"));
        assertEquals("Input or Substring is Null", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> getSubstringCount("java is java", null));
        assertEquals("Input or Substring is Null", exception2.getMessage());
    }

    @Test
    void shouldThrowErrorForEmptyStrings() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> getSubstringCount("", "java"));
        assertEquals("Input or Substring is Empty", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> getSubstringCount("java is java", ""));
        assertEquals("Input or Substring is Empty", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class,
                () -> getSubstringCount("  ".trim(), "java"));
        assertEquals("Input or Substring is Empty", exception3.getMessage());

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class,
                () -> getSubstringCount("java is java", "  ".trim()));
        assertEquals("Input or Substring is Empty", exception4.getMessage());
    }
}
