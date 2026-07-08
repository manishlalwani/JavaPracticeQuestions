package org.practice;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 1, 1, 2, 3 };
        System.out.println(findDuplicates(arr));
    }

    public static String findDuplicates(int[] num) {

        if (num == null)
            return "Input Array cannot be Null";
        if (num.length == 0)
            return "Input Array is Empty";
        if (num.length == 1)
            return "Input Array contains only one element";

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        for (int n : num) {
            if (!seen.add(n)) {
                duplicates.add(n);
            }
        }

        if (!duplicates.isEmpty()) {
            return duplicates.stream().map(String::valueOf)
                    .collect(Collectors.joining(","));
        } else {
            return "No Duplicate Elements Present";
        }
    }

}
