package org.practice.questions;

public class StringOnlyDigits {
    public boolean verifyDigits(String input) {
        if (input == null)
            return false;
        input = input.trim();
        if (input.isEmpty())
            return false;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                return false;

        }
        return true;
    }
}
