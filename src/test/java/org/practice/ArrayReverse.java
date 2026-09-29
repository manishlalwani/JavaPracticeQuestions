package org.practice;

//

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ArrayReverse{

    public static int[] reverseArray(int[] input){// [1,2,3]

        if(input == null ){
            throw new IllegalArgumentException("Array is not valid");
        }
        int left = 0; //0
        int right = input.length-1; //
        while(left < right){ // 0 < 2 , 1 < 1
            int temp = input[left]; // 1
            input[left] = input[right]; // 3
            input[right] = temp; // 1
            left++; // 1
            right--; // 1
        }
        return input;
    }

    @Test
    void shouldReverseArrayWithThreeElements(){
        int[] expected = new int[]{3,2,1};
        int[] inputArray = new int[]{1,2,3};
        assertArrayEquals(expected, reverseArray(inputArray));
    }
    @Test
    void shouldReverseArrayWithTwoElements(){
        int[] expected = new int[]{1,2};
        int[] inputArray = new int[]{2,1};
        assertArrayEquals(expected, reverseArray(inputArray));
    }
    @Test
    void shouldReverseArrayWithFourElements(){
        int[] expected = new int[]{1,2,3,4};
        int[] inputArray = new int[]{4,3,2,1};
        assertArrayEquals(expected, reverseArray(inputArray));
    }
    @Test
    void shouldReverseArrayWithOnelement(){
        int[] expected = new int[]{1};
        int[] inputArray = new int[]{1};
        assertArrayEquals(expected, reverseArray(inputArray));
    }
    @Test
    void shouldReverseArrayWithNegativeNumbers(){
        int[] expected = new int[]{-1,-2,-3,-4};
        int[] inputArray = new int[]{-4,-3,-2,-1};
        assertArrayEquals(expected, reverseArray(inputArray));
    }

    @Test
    void shouldReverseArrayWithDuplicateElements(){
        int[] expected = new int[]{1,2,2,3};
        int[] inputArray = new int[]{3,2,2,1};
        assertArrayEquals(expected, reverseArray(inputArray));
    }

    @Test
    void shouldReverseEmptyArray(){
        int[] inputArray = new int[0];
        int[] expected = new int[0];
        assertArrayEquals(expected, reverseArray(inputArray));
    }

    @Test
    void shouldThrowExceptionForNullArray(){
        int[] inputArray = null;
        assertThrows(IllegalArgumentException.class, () -> reverseArray(inputArray));
    }


}
