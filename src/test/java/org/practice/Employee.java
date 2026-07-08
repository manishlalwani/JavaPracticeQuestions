package org.practice;

import java.util.Arrays;

public class Employee {

    public static void main(String[] args) {
        long[] salary = new long[] { 10000, 20000, 30000, 40000 };

        long highest = Arrays.stream(salary)
                .reduce(0L, (sal1, sal2) -> sal1 < sal2 ? sal2 : sal1);

        System.out.println(highest);
        long secondHighest = Arrays.stream(salary)
                .reduce(highest, (sal1, sal2) -> sal1 < sal2 ? sal1 : sal2);
        System.out.println(secondHighest);
    }
}
