package org.practice.questions;

public class Digit {
    public static int getCountOfDigits(long number){
        //Initilizing counter to 1
        int count = 1;

        //Handle Zero as Special Case
        if(number == 0) return count;
        else{
            if(number < 0) number = Math.abs(number); //Handle Negative number and convert it to positive
            String numberArray = String.valueOf(number); //Convert long number to String --> here 98675 is converted to string "98765"
            count =  numberArray.length();  //Here a string array is created as ["9","8","7","6","5"] -- And then using length property to get count of array
            return count;
        }
        
    }

    public static boolean assertEquals(int expected,int actual){
        return expected == actual;
    }

    public static void main(String[] args){

        System.out.println(assertEquals(5,getCountOfDigits(98765))); // Happy path
        System.out.println(assertEquals(5,getCountOfDigits(-98765))); // Negative number check
        System.out.println(assertEquals(1,getCountOfDigits(0))); //Special Case Check
        System.out.println(assertEquals(1,getCountOfDigits(4))); // Single Digit Check
        System.out.println(assertEquals(20,getCountOfDigits(Long.MIN_VALUE))); // Single Digit Check
        System.out.println(assertEquals(19,getCountOfDigits(Long.MAX_VALUE)));

    }
}
