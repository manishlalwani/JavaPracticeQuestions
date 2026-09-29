package org.practice;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MoveAllZero {
    // Using two pointer approach
    // preserve relative order of non-zero elements
    // Time complexity is O(n) as each element is visited once
    // Space complexity is O(1) as no additonal space is used to store array
    // Modify array in place without extra space
    public static int[] moveAllZero(int[] array) {
        if (array == null) { // Handle Null input gracefully
            throw new IllegalArgumentException("Null Array");
        }
        if (array.length == 0) { // Handle emppty array gracefully
            throw new IllegalArgumentException("Empty Array");
        }

        int i = 0;
        // collecting all non zero's
        for (int left = 0; left < array.length; left++) {
            if (array[left] != 0) {
                array[i++] = array[left];
            }
        }
        // count zeros and place them at endnow remaining positions with zero's
        while (i < array.length) {
            array[i++] = 0;
        }
        return array;
    }

    @Test
    void testValidArrayOutput() {
        int[] input = new int[] { 0, 1, 0, 3, 12 };
        int[] expected = new int[] { 1, 3, 12, 0, 0 };
        int[] actual = moveAllZero(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testNullArray() {
        assertThrows(IllegalArgumentException.class, () -> moveAllZero(null));

    }

    @Test
    void testEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> moveAllZero(new int[0]));
    }

    @Test
    void testAllZeros() {
        int[] input = new int[] { 0, 0, 0 };
        int[] expected = new int[] { 0, 0, 0 };
        int[] actual = moveAllZero(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAlllonZeros() {
        int[] input = new int[] { 1, 2, 3 };
        int[] expected = new int[] { 1, 2, 3 };
        int[] actual = moveAllZero(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAllreadyOrganized() {
        int[] input = new int[] { 4, 5, 0, 0 };
        int[] expected = new int[] { 4, 5, 0, 0 };
        int[] actual = moveAllZero(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSingleElement() {
        int[] input = new int[] { 6 };
        int[] expected = new int[] { 6 };
        int[] actual = moveAllZero(input);
        assertArrayEquals(expected, actual);
    }
}