package org.practice;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesFromString {

    public static String removeDuplicatesFromSentence(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is NUll");
        }
        String normalizedString = input.trim();
        if (normalizedString.isEmpty()) {
            throw new IllegalArgumentException("Input is EMPTY");
        }
        String[] words = normalizedString.split("\\s+");
        // To preserve order we can use linkedhash set
        Set<String> seen = new LinkedHashSet<>();

        for (String word : words) {
            seen.add(word);
        }
        return String.join(" ", seen);
    }

    @Test
    void shouldReturnDeDuplicatedString() {
        assertEquals("your java is coding", removeDuplicatesFromSentence("your java is java coding"));
    }

    @Test
    void shouldPreserveOrderString() {
        assertEquals("java selenium api", removeDuplicatesFromSentence("java selenium java api selenium"));
    }

    @Test
    void shouldHandleSingleWordString() {
        assertEquals("java", removeDuplicatesFromSentence("java"));
    }

    @Test
    void shouldHandleDifferentDuplicatesString() {
        assertEquals("java is coding", removeDuplicatesFromSentence("java java is is coding coding"));
    }

    @Test
    void shouldHandleExtraSpacedDuplicatesString() {
        assertEquals("java is coding", removeDuplicatesFromSentence("  java java is is coding coding  "));
    }
}
