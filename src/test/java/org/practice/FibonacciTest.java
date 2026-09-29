package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class FibonacciTest {

    @Test
    void shouldGenerateFibonacciSequenceForNumberN() {
        assertEquals(
                List.of(0, 1, 1, 2, 3, 5),
                generateFibonacci(6));
    }

     @Test
    void shouldGenerateFibonacciSequenceForLargerNumberN() {
        assertEquals(
                List.of(0, 1, 1, 2, 3, 5,8,13,21,34),
                generateFibonacci(10));
    }

     @Test
    void shouldGenerateFibonacciSequenceForNumberTwo() {
        assertEquals(
                List.of(0, 1),
                generateFibonacci(2));
    }
   

    @Test
    void shouldGenerateFibonacciSequenceForNumberOne() {
        assertEquals(
                List.of(0),
                generateFibonacci(1));
    }

    @Test
    void shouldThrowErrorForZero(){
        assertThrows(IllegalArgumentException.class, () ->{
            generateFibonacci(0);
        });
    }

    @Test
    void shouldThrowErrorForNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () ->{
            generateFibonacci(-4);
        });
    }

    public static List<Integer> generateFibonacci(int n) {
        List<Integer> fib = new ArrayList<>();
        if (n <= 0) {
            throw new IllegalArgumentException("Enter Positive number");
        }
        if (n == 1) {
            fib.add(0);
            return fib;
        }
        int firstNumber = 0;
        int secondNumber = 1;
        fib.add(firstNumber);
        fib.add(secondNumber);

        int i = 3;
        while (i <= n) {
            int nextNumber = secondNumber + firstNumber;
            fib.add(nextNumber);
            i++;
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
        return fib;
    }
}