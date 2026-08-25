package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReverseNumberTest {

    public long reverseNumber(long num) {
        long numReversed = 0;
        boolean isNegative = num < 0;
        num = Math.abs(num);
        // num -> 12345
        while (num > 0) {
            long digit = num % 10;// 5, 4, 3, 2, 1
            numReversed = numReversed * 10 + digit; // 5, 5*10+4=54, 54*10+3=543,543*10+2=5432, 5432*10+1 =54321
            num = num / 10;// 1234,123,12,1
        }
        return isNegative ? -numReversed : numReversed;
    }

    @Test
    public void shouldReverseFiveDigitNumber() {
        assertEquals(54321, reverseNumber(12345));
    }

    @Test
    public void shouldReverseOneDigitNumber() {
        assertEquals(1, reverseNumber(1));
    }

    @Test
    public void shouldReverseTwoDigitNumber() {
        assertEquals(91, reverseNumber(19));
    }

    @Test
    public void shouldReverseFourDigitNumber() {
        assertEquals(8132, reverseNumber(2318));
    }

    @Test
    public void shouldReverseZero() {
        assertEquals(0, reverseNumber(0));
    }

    @Test
    public void shouldReverseNegativeTwoDigitNumber() {
        assertEquals(-12, reverseNumber(-21));
    }

    @Test
    public void shouldReversePositiveNumberEndingWithZero() {
        assertEquals(12, reverseNumber(210));
    }

    @Test
    public void shouldReverseNegativeNumberEndingWithZero() {
        assertEquals(-12, reverseNumber(-210));
    }

    @Test
    public void shouldReversePalindromeNumber() {
        assertEquals(121, reverseNumber(121));
    }
}
