package org.practice;

public class PrimeNumbers {

    public static void printPrime(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Enter Number greater than 0");
        }

        boolean first = true;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {

                if (!first) {
                    System.out.print(",");
                }
                System.out.print(i);
                first = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        printPrime(20);
    }
}
