package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ReverseString {
    public static String reverseString(String input){
        if(input == null){
            throw new IllegalArgumentException("String is Null");
        }
        String normalizedString = input.trim();//to remove additional space

        if(normalizedString.isEmpty()){
            throw new IllegalArgumentException("String is Empty");
        }
        if(input.length() == 1){//Single letter string
            return input;
        }
        char[] characterArray  = normalizedString.toCharArray(); // convert String to char array for manipulation
        int left = 0; //using 2 pointer approach
        int right = characterArray.length-1;

        while(left <= right){//this will handle the odd length string
            char temp = characterArray[left];
            characterArray[left] = characterArray[right];
            characterArray[right] = temp;
            left++;
            right--;
        }
        return new String(characterArray);
    }

    @Test
    void shouldReturnReversedStringEvenLength(){
        assertEquals("neevan",reverseString("naveen"));
    }

    @Test
    void shouldReturnReversedStringOddLength(){
        assertEquals("nanab",reverseString("banan"));
    }

    @Test
    void shouldReturnReversedStringSingleCharacter(){
        assertEquals("a",reverseString("a"));
    }

    @Test
    void shouldReturnReversedStringMixedCase(){
        assertEquals("abNBa",reverseString("aBNba"));
    }

    @Test
    void shouldReturnReversedStringSpecialCharacter(){
        assertEquals("&^%#",reverseString("#%^&"));
    }

    @Test
    void shouldReturnReversedStringNumericString(){
        assertEquals("1234",reverseString("4321"));
    }

    @Test
    void shouldReturnReversedStringAlphanumericString(){
        assertEquals("abc12bc",reverseString("cb21cba"));
    }

    @Test
    void shouldReturnReversedStringWithSpaceInBetween(){
        assertEquals("abc 321a",reverseString("a123 cba"));
    }

    @Test
    void shouldThrowErrorNullString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> reverseString(null));
        assertEquals("String is Null",exception.getMessage());
    }

    @Test
    void shouldThrowErrorEmptyString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reverseString(""));
        assertEquals("String is Empty",exception.getMessage());
    }

    @Test
    void shouldThrowErrorEmptyStringWithSpaces(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> reverseString("  "));
        assertEquals("String is Empty",exception.getMessage());
    }
}