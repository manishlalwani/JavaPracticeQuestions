package org.practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.practice.questions.StringOnlyDigits;

public class StringOnlyDigitsTest {

    private StringOnlyDigits stringOnlyDigits;

    @BeforeEach
    void setUp() {
        stringOnlyDigits = new StringOnlyDigits();
    }

    @Test
    public void shouldReturnTrueForAllDigits() {
        assertTrue(stringOnlyDigits.verifyDigits("445454"));
    }

    @Test
    public void shouldReturnFalseForAlphanumeric() {
        assertFalse(stringOnlyDigits.verifyDigits("44a5454"));
    }

    @Test
    public void shouldReturnTrueWithLeadingTrailingSpaces() {
        assertTrue(stringOnlyDigits.verifyDigits(" 445454  "));
    }

    @Test
    public void shouldReturnFalseForNullInputString() {
        assertFalse(stringOnlyDigits.verifyDigits(null));
    }

    @Test
    public void shouldReturnFalseForEmptyInputString() {
        assertFalse(stringOnlyDigits.verifyDigits(" "));
    }

    @Test
    void shouldReturnFalseForDigitsWithInternalSpaces() {
        assertFalse(stringOnlyDigits.verifyDigits("123 456"));
    }

    @Test
    void shouldReturnFalseForSpecialCharacters() {
        assertFalse(stringOnlyDigits.verifyDigits("123@45"));
    }

    @Test
    void shouldReturnFalseForDecimalNumbers() {
        assertFalse(stringOnlyDigits.verifyDigits("123.45"));
    }

    @Test
    void shouldReturnFalseForNegativeNumbers() {
        assertFalse(stringOnlyDigits.verifyDigits("-123"));
    }

    @Test
    void shouldReturnTrueForLeadingZeros() {
        assertTrue(stringOnlyDigits.verifyDigits("000123"));
    }

    @Test
    void shouldReturnFalseForEmptyString() {
        assertFalse(stringOnlyDigits.verifyDigits(""));
    }

}
