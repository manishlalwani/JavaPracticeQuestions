package org.practice;

public class Fibonacci {

    public static void main(String[] args) {
        printFibonacci(7);

    }

    public static void printFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Enter Positive number");
        }
        if (n == 1) {
            System.out.print(0);
        }
        int firstNumber = 0;
        int secondNumber = 1;
        System.out.print(firstNumber);
        System.out.print(",");
        System.out.print(secondNumber);

        int i = 3;
        while (i <= n) {
            secondNumber = secondNumber + firstNumber;
            System.out.print(secondNumber);
            System.out.print(",");
            i++;
        }
    }
}