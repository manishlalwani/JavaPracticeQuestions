package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringRever {

    public String reverseString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        String trimmedInput = input.trim();
        if (trimmedInput.length() == 0) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        char[] characterArray = trimmedInput.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = characterArray.length - 1; i >= 0; i--) {
            stringBuilder.append(characterArray[i]);
        }
        return stringBuilder.toString();
    }

    @Test
    public void verifySingleWordReverse() {
        assertEquals("hsinam", reverseString("manish"));
    }

    @Test
    public void verifyTwoWordReverse() {
        assertEquals("inawlal hsinam", reverseString("manish lalwani"));
    }

    @Test
    public void verifySingleCharacterReverse() {
        assertEquals("A", reverseString("A"));
    }

    @Test
    public void verifyAlphanumnericStringReverse() {
        assertEquals("ABC6*B", reverseString("B*6CBA"));
    }

    @Test
    public void verifySpecialCharacterStringReverse() {
        assertEquals("&*@3%^()", reverseString(")(^%3@*&"));
    }

    @Test
    public void verifySpacesAtLeftAndRightStringReverse() {
        assertEquals("LAPOHB", reverseString(" BHOPAL "));
    }

    @Test
    public void verifyAdditionSpacesStringReverse() {
        assertEquals("inawlal    hsinam", reverseString("manish    lalwani"));
    }

    @Test
    public void verifyNullStringReverse() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reverseString(null));
        assertEquals("String cannot be null", exception.getMessage());
    }

    @Test
    public void verifyEmptyStringReverse() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reverseString(" "));
        assertEquals("String cannot be empty", exception.getMessage());
    }

    @Test
    public void verifyMultipleSpacesStringReverse() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reverseString("    "));
        assertEquals("String cannot be empty", exception.getMessage());
    }

}
