package org.practice;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MostRepeatedWord {

    public static String getMostRepeatedWord(String input) {

        if (input == null) {
            throw new IllegalArgumentException("String is Null");
        }
        String normalizedInput = input.toLowerCase().trim();
        if (normalizedInput.isEmpty()) {
            throw new IllegalArgumentException("String is Empty");
        }
        String[] words = normalizedInput.split("\\s+");

        Map<String, Integer> countFrequency = new LinkedHashMap<>();
        for (String word : words) {
            countFrequency.put(word, countFrequency.getOrDefault(word, 0) + 1);
        }
        int maxCount = 1;
        String mostRepeatedWord = "";
        for (Map.Entry<String, Integer> entry : countFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostRepeatedWord = entry.getKey();
            }

        }
        return mostRepeatedWord;

    }

    @Test
    void shouldReturnMostFrequentWord() {
        assertEquals("this", getMostRepeatedWord("this is test this good"));
    }

    @Test
    void shouldReturnMostFrequentWordAndReturnFirstOne() {
        assertEquals("apple", getMostRepeatedWord("apple banana apple banana"));
    }

    @Test
    void shouldReturnMostFrequentWordWithSpaces() {
        assertEquals("this", getMostRepeatedWord("  this is test this is good "));
    }

    @Test
    void shouldReturnMostFrequentWordWithThreeCount() {
        assertEquals("is", getMostRepeatedWord("this is test this is good is"));
    }

    @Test
    void shouldReturnMostFrequentWordWithSpecialCharacterString() {
        assertEquals("*&*&", getMostRepeatedWord("this is *&*& this *&*& good *&*&"));
    }

    @Test
    void shouldReturnMostFrequentWordWithNumericCharacterString() {
        assertEquals("345", getMostRepeatedWord("this is 345 this 345 good 345"));
    }

    @Test
    void shouldThrowErrorForEmpty() {
        String input = " ";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getMostRepeatedWord(input));
        assertEquals("String is Empty", exception.getMessage());
    }

    @Test
    void shouldThrowErrorForNull() {
        String input = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> getMostRepeatedWord(input));
        assertEquals("String is Null", exception.getMessage());
    }
}
