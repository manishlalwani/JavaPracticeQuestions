package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GCD {

    public static int getGCD(int num1, int num2) {

        while (num2 != 0) { //18 , 12 , 6 , 0
            int temp = num2; //18 , 12, 6
            num2 = num1 % num2; // 12%18=12, 12%18 = 6, 12%6 = 0
            num1 = temp; //18, 12 , 6
        }
        return num1;//6
    }

    public static int getLCM(int num1, int num2) {
        return Math.abs(num1 * num2) / getGCD(num1, num2);
    }

    @Test
    void shouldReturnGCDForPositiveNumbers(){
        assertEquals(6,getGCD(12,18));
    }

    @Test
    void shouldReturnGCDForPositiveNumbersSameNumber(){
        assertEquals(15,getGCD(15,15));
    }

    @Test
    void shouldHandleOneAsInput(){
        assertEquals(1,getGCD(1,25));
        assertEquals(1,getGCD(25,1));
    }

    @Test
    void shouldHandleCoPrimeNumbers(){
        assertEquals(1,getGCD(17,19));
    }

    @Test
    void shouldThrowErrorWhenAnyNumberIsZero(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> getGCD(0,12));
        assertEquals("Input Number is 0",exception.getMessage());
        IllegalArgumentException exception1 =  assertThrows(IllegalArgumentException.class, () -> getGCD(12,0));
        assertEquals("Input Number is 0", exception1.getMessage());
    }

}
