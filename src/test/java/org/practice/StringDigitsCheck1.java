package org.practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

//Clarify - 1. If Input String Contains Leading Trailing Spaces
    //          2. If Input String Contains Negative or Minus Sign - "-234"
    //          3. If Input String has Spaces in- between - "123 45"
    //          4. Can Input String be Null?
    //          5. Can Input String Be Empty
    //          6. Can String is decimal in between
    //          Assuming Answer to all of above is Yes
    
    //Writing below Method
public class StringDigitsCheck1{
        public boolean checkDigitsInString(String input){
            //Handle Null String Input 
            if(input == null) return false;
            //Handle Empty String Input
            //Time Complexity is O(n) as trim reads string and trims it
            input = input.trim();
            if(input.isEmpty()) return false;
            //Iterate Each Element of String and not Storing in array thus making it Space Complexity as O(1)
    
            for(int i=0;i<input.length();i++){
                char ch = input.charAt(i);
                if(ch < '0' || ch > '9') return false; //Return false as soon as Non-digit character is found
            }
            return true; //Returns true only if all characters are digits
        }
    
    
        @Test
        public void shouldReturnTrueForStringHasOnlyDigits(){
            assertTrue(checkDigitsInString("12345"));
        }
        @Test
        public void shouldReturnTrueForStringHasSpacesInBetweenDigits(){
            assertFalse(checkDigitsInString("123  45"));
        }
        @Test
        public void shouldReturnTrueForStringHasLeadingTrailingSpaces(){
            assertTrue(checkDigitsInString("  1234    "));
        }
        @Test
        public void shouldReturnTrueForStringHasLeadingZeros(){
            assertTrue(checkDigitsInString("1230000"));
        }
        @Test
        public void shouldReturnTrueForStringHasHeadingZeros(){
            assertTrue(checkDigitsInString("000012234"));
        }
        @Test
        public void shouldReturnFalseForStringIsAlphaNumeric(){
            assertFalse(checkDigitsInString("11223a34343"));
        }
        @Test
        public void shouldReturnFalseForStringIsNegative(){
            assertFalse(checkDigitsInString("-123"));
        }
        @Test
        public void shouldReturnFalseForStringHasDecimal(){
            assertFalse(checkDigitsInString("123.3434"));
        }
        @Test
        public void shouldReturnFalseForStringIsEmpty(){
            assertFalse(checkDigitsInString(""));
        }
        @Test
        public void shouldReturnFalseForStringIsEmptyWithSpaces(){
            assertFalse(checkDigitsInString("  "));
        }
        @Test
        public void shouldReturnFalseForStringIsNull(){
            assertFalse(checkDigitsInString(null));
        }
    }



