package org.practice;

//clarification - return type of method should be character or string -- Lets return character
//clarification - input will always be one word sring or multiple words - Lets take one word string
//clarification - should character return be case sensitive = yes lets keep case sensitive return
import java.util.Map;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NonRepeatedCharacter {

    public static Character getNonRepeatedCharacter(String input) {
        // We will use Linked HashMap as it will store order of insertion as output
        // needs first non repeated character

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        if (input == null) { // Handle null string
            throw new IllegalArgumentException("String is Null Please input valid string");
        }
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty()) {// Handle empty string
            throw new IllegalArgumentException("String is Empty Please enter string with tokens");
        }

        for (char c : trimmedInput.toCharArray()) { // count frequency of each character in string //swiss
            countMap.put(c, countMap.getOrDefault(c, 0) + 1); // s-1 --> s-1,w-1 -->s-1,w-1,i-1 -->s-2,w-1,i-1 -->
                                                              // s-3,w-1,i-1
        }

        // Iterate through string map to find first non repeated char

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) { // s-3, w--1
                return entry.getKey(); // return character which is non repeated first // w
            }
        }
        return null;// return null if all characters repeat
    }

    @Test
    void shouldReturnNonRepeatedCharacter() {
        Character result = getNonRepeatedCharacter("swiss");
        assertEquals('w', result);
    }

    @Test
    void shouldReturnNonRepeatedCharacterWithAdditionalSpaces() {
        Character result = getNonRepeatedCharacter(" swiss ");
        assertEquals('w', result);
    }

    @Test
    void shouldReturnNullNonRepeatedCharacter() {
        assertNull(getNonRepeatedCharacter("swWiIisIswW"));
    }

    @Test
    void shouldReturnNonRepeatedCharacterWithSpecialCharacter() {
        assertEquals('$', getNonRepeatedCharacter("%^$^%"));
    }

    @Test
    void shouldReturnNonRepeatedCharacterForNumericString() {
        assertEquals('1', getNonRepeatedCharacter("21323"));
    }

    @Test
    void shouldThrowErrorNullString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getNonRepeatedCharacter(null));
        assertEquals("String is Null", exception.getMessage());
    }

    @Test
    void shouldThrowErrorEmptyString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getNonRepeatedCharacter(""));
        assertEquals("String is Empty", exception.getMessage());

    }

    @Test
    void shouldThrowErrorEmptyStringWithSpaces() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getNonRepeatedCharacter("  "));
        assertEquals("String is Empty", exception.getMessage());
    }
}
