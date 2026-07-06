package org.practice.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicateCharacters {

    public static void main(String[] args) {
        String input = "programming";
        // Ignore case

        if (input == null || input.isEmpty())
            return;
        input = input.trim().toLowerCase();
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (char ch : input.toCharArray()) {
            charCount.put(ch, (charCount.getOrDefault(ch, 0)) + 1);
        }
        Map<Character, Integer> dupCharCount = new HashMap<>();
        for(Map.Entry<Character,Integer> entry : charCount.entrySet()){
            if(entry.getValue()>1){
                dupCharCount.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println(dupCharCount);
    }
}
