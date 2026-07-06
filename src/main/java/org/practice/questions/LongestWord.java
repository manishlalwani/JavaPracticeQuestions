package org.practice.questions;

public class LongestWord{
    public static String getLongestWord(String input){
    
    //Handle Null String
        if(input == null){
            return "String cant be Null";
        }
        //Handle Empty String
        String trimmedInput = input.trim();
        if(trimmedInput.isEmpty()){
            return "String cant be Empty";
        }
        String[] words = trimmedInput.split("\\s+");
        //Handle Spaces String
        if(words[0].trim().length() == 0){
            return "String cant be Empty";
        }
        //Handle Single Word String
        if(trimmedInput.length() == 1){
            return words[0];
        }else{
            String longest = words[0]; 
            int max = words[0].length();
            for(String word : words){ //Track longest words and its length
                if(word.length() > max){
                    longest = word;
                    max = longest.length();
                }
            }
            return longest;
        }
    }

    //Test Function
    public static String testMethod(String expected, String actual){
        if(expected.equalsIgnoreCase(actual)) return "Pass";
        else return "Fail";
    }

    public static void main(String[] args){

    System.out.println(testMethod("Automation",getLongestWord("I Love Automation Testing"))); //Pass
    System.out.println(testMethod("Automation",getLongestWord("I love Automation"))); //Edge Case
    System.out.println(testMethod("Automation",getLongestWord("Automation"))); //Single Word
    System.out.println(testMethod("String cant be Null",getLongestWord(null))); //testing null Case
    System.out.println(testMethod("String cant be empty",getLongestWord(""))); //tetsing empty String
    System.out.println(testMethod("Love",getLongestWord("I.    Love  "))); //Spaces Check
    System.out.println(testMethod("String cant be empty",getLongestWord("    ")));//white spaces only
    }
} 
    

