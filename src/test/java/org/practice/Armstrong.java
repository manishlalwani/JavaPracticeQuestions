package org.practice;

//Clarify definition of armstrong number 
//When the sum of cube powered digits is equal to number then it is armstrong number
//153 = 1^3+5^3+3^3 = 1+125+27 = 153

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class Armstrong{

    public static long getSumOfPower(long n){
        if(n <= 0){
            throw new IllegalArgumentException("Enter Positive Number");
        }
        if(n < 10 && n > 0){
            return n;
        }
        int power = String.valueOf(n).length();
        long sum = 0l;
        while(n > 0){ //153, 15, 1
            int rem = (int)n%10; //3 , 5, 1
            sum +=  Math.pow(rem, power); // 27, 27 + 5*5*5= 27+125=152 , 152+1*1*1 = 153
            n /= 10; //15 // 1
        }
        return sum;
    }

    @Test
    void testArmstrongNumberThreeDigit(){
        assertEquals(153,getSumOfPower(153));
    }
    @Test
    void testArmstrongNumberFourDigit(){
        assertEquals(1634,getSumOfPower(1634));
    }
    @Test
    void testArmstrongNumberSingleDigit(){
        assertEquals(2,getSumOfPower(2));
    }

    @Test
    void testArmstrongNumberNegativeDigit(){
        assertThrows(IllegalArgumentException.class, () -> getSumOfPower(-4));
    }

}