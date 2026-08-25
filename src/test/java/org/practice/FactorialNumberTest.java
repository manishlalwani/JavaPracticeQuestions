package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FactorialNumberTest {

    public long factorialNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            if (factorial > Long.MAX_VALUE / i) {
                throw new ArithmeticException("Factorial exceeds long range");
            }
            factorial *= i;
        }
        return factorial;
    }

    @Test
    public void shouldCalculateFactorialOfFive() {
        assertEquals(120, factorialNumber(5));
    }

    @Test
    public void shouldCalculateFactorialOfOne() {
        assertEquals(1, factorialNumber(1));
    }

    @Test
    public void shouldCalculateFactorialOfZero() {
        assertEquals(1, factorialNumber(0));
    }

    @Test
    public void shouldRejectNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> factorialNumber(-5));
    }

    @Test
    public void shouldCalculateFactorialOfTwenty() {
        assertEquals(2432902008176640000L, factorialNumber(20));
    }

    @Test
    public void shouldRejectFactorialBeyondLongRange() {
        assertThrows(ArithmeticException.class, () -> factorialNumber(21));
    }
}
