package org.practice.questions;

public class ReverseEachWord {

    public String getReverseSentence(String sentence) {
        if (sentence == null)
            throw new IllegalArgumentException("Sentence cannot be Null");
        sentence = sentence.trim();
        if (sentence.isEmpty())
            throw new IllegalArgumentException("Sentence cannot be Empty");
        StringBuilder reversedString = new StringBuilder(sentence.length());

        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            reversedString.append(reverseEachWord(words[i]));
            if (i < words.length - 1) {
                reversedString.append(" ");
            }
        }
        return reversedString.toString();
    }

    public String reverseEachWord(String inputString) {

        StringBuilder stringResult = new StringBuilder();
        for (int i = inputString.length() - 1; i >= 0; i--) {
            stringResult.append(inputString.charAt(i));
        }
        return stringResult.toString();

    }

}
