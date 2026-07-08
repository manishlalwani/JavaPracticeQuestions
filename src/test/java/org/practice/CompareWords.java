package org.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CompareWords {

    public static void main(String[] args) {
        System.out.println(compareWords("java selenium playwright", "java python playwright"));
        System.out.println(compareWords("java playwright", "playwright java csharp"));
        System.out.println(compareWords("java playwright", "playwright java"));
        System.out.println(compareWords("java playwright", "playwright       java"));
        System.out.println(compareWords("java", "java"));
        System.out.println(compareWords("java", "playwright"));
        System.out.println(compareWords("", "playwright"));
        System.out.println(compareWords(null, "playwright"));
    }

    public static String compareWords(String input1, String input2) {
        if (input1 == null || input2 == null)
            return "Input String can't be Null";
        input1 = input1.trim().toLowerCase();
        input2 = input2.trim().toLowerCase();

        if (input1.isEmpty() || input2.isEmpty())
            return "Input String can't be Empty";


        Set<String> firstWordSet = new HashSet<>(Arrays.asList(input1.split("\\s+")));
        Set<String> secondWordSet = new HashSet<>(Arrays.asList(input2.split("\\s+")));
        
        return firstWordSet.equals(secondWordSet) ? "Both Strings are same" :  "Both Strings are not equal";
    }
}
