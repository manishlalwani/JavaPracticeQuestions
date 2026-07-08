package org.practice.questions;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountFrequencyString {
    public Map<Character, Integer> countFrequency(String input) {

        if (input == null) {
            return Collections.emptyMap();
        }
        input = input.trim().replaceAll("\\s+", "");
        if (input.isEmpty())
            return Collections.emptyMap();

        Map<Character, Integer> charFrequency = new LinkedHashMap<>();
        // Time Complexity :  O(n) - Each Character is Processed exatcly Once
        for (char ch : input.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }
        return charFrequency;
    }
}
