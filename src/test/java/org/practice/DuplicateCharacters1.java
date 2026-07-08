// package org.practice;

// import java.util.Map;

// import org.junit.Test;

// import java.util.HashMap;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

// public class DuplicateCharacters1 {

//     // Method to Return HashMap Which contains duplicate counts of each
//     // DuplicateCharacter
//     // Input is Single word String

//     public static HashMap<Character, Integer> getDuplicateCharacter(String input) {
//         HashMap<Character, Integer> dupCountChar = new HashMap<>();
//         // Handle Null String
//         if (input == null)
//             return dupCountChar;
//         // Handle Empty String
//         input = input.trim();
//         if (input.isEmpty())
//             return dupCountChar;

//         Map<Character, Integer> countChar = new HashMap<>();

//         // Now Considering Positive Scenario of Valid String and updating to lower case
//         // to handle case and iterate through each character once and Use HashMap to
//         // store character and its frequencies
//         for (Character ch : input.toLowerCase().toCharArray()) { // Transforming String to Character array
//             countChar.put(ch, countChar.getOrDefault(ch, 0) + 1);
//         }
//         // Filtering Unique records and keeping > 1 records
//         for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
//             if (entry.getValue() > 1) {
//                 dupCountChar.put(entry.getKey(), entry.getValue());
//             }
//         }
//         return dupCountChar;
//     }

//     @Test // Testing Happy Path
//     public void testHappyPath() {
//         String input = "programming";
//         HashMap<Character, Integer> expected = new HashMap<>();
//         expected.put('r', 2);
//         expected.put('g', 2);
//         expected.put('m', 2);
//         assertEquals(expected, getDuplicateCharacter(input));
//     }

//     @Test
//     public void testNonDuplicateString() {
//         String input = "abc";
//         assertTrue(getDuplicateCharacter(input).isEmpty());
//     }

//     @Test
//     public void testNullString() {
//         String input = null;
//         assertTrue(getDuplicateCharacter(input).isEmpty());
//     }

//     @Test
//     public void testEmptyString() {
//         String input = "";
//         assertTrue(getDuplicateCharacter(input).isEmpty());
//     }

//     @Test
//     public void testSpaceEmptyString() {
//         String input = "     ";
//         assertTrue(getDuplicateCharacter(input).isEmpty());
//     }
// }
