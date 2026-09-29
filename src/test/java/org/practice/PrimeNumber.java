package org.practice;


//Check whether the numnber is prime or not
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PrimeNumber{

    public static boolean isPrime(long number){
        if(number <= 1)return false;
        if(number <= 3)return true;
        //Eliminiate multiples of 2 and 3
        if( number%2 ==0 || number%3 ==0) return false;
        //Check divisors upto square root of n
        for(long i = 5; i*i <= number; i+=6){
            if(number%i ==0 || number%(i+2) ==0){
                return false;
            }
        }
    return true;
    }

    @Test
    void testPrimeNumberPositive(){
        assertTrue(isPrime(17));
    }
    @Test
    void testPrimeNumberOne(){
        assertFalse(isPrime(1));
    }
    @Test
    void testPrimeNumberTwo(){
        assertTrue(isPrime(2));
    }
    @Test
    void testPrimeNumberThree(){
        assertTrue(isPrime(3));
    }
    @Test
    void testPrimeNumberNegative(){
        assertFalse(isPrime(-4));
    }

    @Test
    void testPrimeNumberNegativeCase(){
        assertFalse(isPrime(9));
    }
    @Test
    void testPrimeNumberTwoDigit(){
        assertFalse(isPrime(15));
    }
    @Test
    void testPrimeNumberThreeDigit(){
        assertTrue(isPrime(101));
    }
}
