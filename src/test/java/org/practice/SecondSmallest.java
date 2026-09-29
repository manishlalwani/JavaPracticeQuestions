package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SecondSmallest {
    

    public static int getSecondSmallestInteger(int[] input){
    
        int first_smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;
        for(int i = 0 ;i < input.length;i++){//i=0,1
            if(input[i] < first_smallest && input[i] < second_smallest){
                second_smallest = first_smallest;//Max_value, 10
                first_smallest = input[i]; // 10, 5
            }else if(input[i] < second_smallest){
                second_smallest = input[i];//8
            }
        }
        return second_smallest;
    }

   @Test
    void shouldReturnSecondSmallest(){
        assertEquals(8, getSecondSmallestInteger(new int[]{10,5,20,8}));
    }
    @Test
    void shouldReturnSecondSmallestWithSameInteger(){
        assertEquals(8,getSecondSmallestInteger(new int[]{8,8,8,8}));
    }

    @Test
    void shouldReturnSecondSmallestForDuplicateSecondSmallest(){
        assertEquals(5,getSecondSmallestInteger(new int[]{5,5,8}));
    }
    @Test
    void shouldReturnSecondSmallestFromTwoIntegerArray(){
        assertEquals(8,getSecondSmallestInteger(new int[]{5,8}));
        assertEquals(8,getSecondSmallestInteger(new int[]{8,5}));
    }
    @Test
    void shouldReturnSecondSmallestForNegativeIntegers(){
        assertEquals(-10,getSecondSmallestInteger(new int[]{-5,-10,-15,-1}));
    }

    @Test
    void shouldReturnSecondSmallestForMixedArray(){
        assertEquals(-3,getSecondSmallestInteger(new int[]{-5,-3,1,2}));
    }

    @Test
    void shouldThrowErrorForSingleElement(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> getSecondSmallestInteger(new int[]{1}));
        assertEquals("Array should contain atleast 2 integers",exception.getMessage());
    }

    @Test
    void shouldThrowErrorForZeroElement(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> getSecondSmallestInteger(new int[]{}));
        assertEquals("Array should contain atleast 2 integers", exception.getMessage());
    }

    @Test
    void shouldThrowErrorForNullElement(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> getSecondSmallestInteger(null));
        assertEquals("Array should contain atleast 2 integers", exception.getMessage());
    }
}
