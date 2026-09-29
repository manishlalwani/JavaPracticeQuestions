package org.practice;
//clarification - are comparisons case sensitive? - let says we have to consider case insensitive

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckSentences {

    // Time Complexity is O(log n) as we are using set to store and compare data
    public static boolean compareSentence(String input1, String input2) {
        if (input1 == null || input2 == null) {
            throw new IllegalArgumentException("Sentences are Null");
        }

        // trim whitespaces around strings
        input1 = input1.trim();
        input2 = input2.trim();

        if (input1.isBlank() || input2.isBlank()) {
            throw new IllegalArgumentException("Sentences are Empty");
        }

        // split strings into words list
        String[] words1 = input1.toLowerCase().split("\\s+");// Handle case sensitivity
        String[] words2 = input2.toLowerCase().split("\\s+");

        Set<String> wordSet1 = new HashSet<>(Arrays.asList(words1));
        Set<String> wordSet2 = new HashSet<>(Arrays.asList(words2));

        return wordSet1.equals(wordSet2);// comparing words sets ignoring order
    }

    @Test
    void shouldReturnTrueForSentences() {
        assertTrue(compareSentence("java python", "python java"));
    }

    @Test
    void shouldReturnFalseForSentences() {
        assertFalse(compareSentence("java selenium", "python java"));
    }

    @Test
    void shouldThrowErrorForNullString() {
        assertThrows(IllegalArgumentException.class, () -> compareSentence(null, "java python"));
    }

    @Test
    void shouldThrowErrorForEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> compareSentence("", "Empty"));
    }
}