package org.practice;

public class StringPermutation {

    public static void printPermutation(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String is Null");
        }

        if (input.isEmpty()) {
            return;
        }
        permutationHelper(input, "");
    }

    private static void permutationHelper(String input, String ans) {
        if (input.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String left = input.substring(0, i);
            String right = input.substring(i + 1);
            permutationHelper(left + right, ch + ans);
        }
    }

    public static void main(String[] args) {
        printPermutation("ABC");

    }
}
