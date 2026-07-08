package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.practice.questions.CountFrequencyString;

public class CountFrequencyStringTest {

    CountFrequencyString countFrequencyString;

    @BeforeEach
    public void setUp() {
        countFrequencyString = new CountFrequencyString();
    }

    @Test
    public void shouldReturnCharacterFrequncy() {

        Map<Character, Integer> expected = Map.of('a', 2, 'b', 2, 'c', 1);
        assertEquals(expected, countFrequencyString.countFrequency("aabbc"));
    }

    @Test
    public void shouldReturnCharacterFrequncyForNumbers() {

        Map<Character, Integer> expected = Map.of('1', 2, '2', 2, '3', 1);

        assertEquals(expected, countFrequencyString.countFrequency("11223"));
    }

    @Test
    public void shouldReturnCharacterFrequncyForMixedCase() {

        Map<Character, Integer> expected = Map.of('a', 2, 'A', 2);

        assertEquals(expected, countFrequencyString.countFrequency("aaAA"));
    }

    @Test
    public void shouldReturnHashMapWithCharAndFrequncyNoDuplicates() {

        Map<Character, Integer> expected = Map.of('a', 1, 'b', 1, 'c', 1);
        assertEquals(expected, countFrequencyString.countFrequency("abc"));
    }

    @Test
    public void shouldReturnHashMapWithCharAndFrequncyWithLeadingTrailingSpaces() {

        Map<Character, Integer> expected = Map.of('a', 2, 'b', 2, 'c', 1);
        assertTrue(expected.equals(countFrequencyString.countFrequency("   aabbc  ")));
    }

    @Test
    public void shouldReturnHashMapWithCharAndFrequncyWithSpacesInBetween() {

        Map<Character, Integer> expected = Map.of('a', 2, 'b', 2, 'c', 1);
        assertTrue(expected.equals(countFrequencyString.countFrequency("   a a b  bc  ")));
    }

    @Test
    public void shouldReturnEmptyMapForNullInput() {

        assertEquals(Collections.emptyMap(), countFrequencyString.countFrequency(null));
    }

    @Test
    public void shouldReturnEmptyMapForEmptyInput() {

        assertEquals(Collections.emptyMap(), countFrequencyString.countFrequency(""));
    }

    @Test
    public void shouldReturnEmptyMapForBlankInput() {

        assertEquals(Collections.emptyMap(), countFrequencyString.countFrequency("   "));
    }

    @Test
    public void shouldReturnEmptyMapForNewLineInput() {

        assertEquals(Collections.emptyMap(), countFrequencyString.countFrequency("\n"));
    }

    @Test
    public void shouldReturnEmptyMapForTabInput() {

        assertEquals(Collections.emptyMap(), countFrequencyString.countFrequency("\t"));
    }

    @Test
    void shouldReturnCharacterFrequencyForSpecialCharacters() {
        Map<Character, Integer> expected = Map.of(
                '!', 2,
                '@', 2,
                '#', 1);

        assertEquals(expected,
                countFrequencyString.countFrequency("!!@@#"));
    }

    @Test
    void shouldReturnCharacterFrequencyForAlphaNumericCharacters() {
        Map<Character, Integer> expected = Map.of(
                'a', 2,
                '1', 2,
                'b', 1);

        assertEquals(expected,
                countFrequencyString.countFrequency("aa11b"));
    }

}
