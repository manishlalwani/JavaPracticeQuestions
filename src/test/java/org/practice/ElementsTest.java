package org.practice;




import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class ElementsTest {

    // public static void main(String[] args) {
    //     System.out.println(findDuplicates(new int[] { 1, 2, 3, 1, 1, 4, 3 }));
    // }

    public static String findDuplicates(int[] num) {
        // Handle Null Case
        if (num == null)
            return "Input Array Cannot be Null";
        // Handle Empty Array
        if (num.length == 0)
            return "Input Array Cannot be Empty";
        // Handle Single Element Array
        if (num.length == 1)
            return "Input Array contains only one element";

        // Happy Paths Using Time Complexity as O(n) as iteratging each element is
        // required and Space Complexity as O(n)
        // HashSet is Used to map input array and track seen elements
        // Another HashSet is used to track duplicate elements
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        // Iterate Each Element of Input Array
        for (int number : num) { // 1,2,3,2,4,1
            if (!seen.add(number)) {// false,false,false,true,false,true
                duplicate.add(number); // no action,no action,no action,2,no action,1
            }
        }
        if (!duplicate.isEmpty()) {// duplicate has 2,1
            return duplicate.stream().map(String::valueOf).collect(Collectors.joining(","));
        } else {
            return "Input Array has No Duplicate Elements";
        }
    }



    @Test
    public void verifyHappyPath() {
    int[] num = new int[] { 1, 2, 3, 2, 4, 1 };
    assertEquals("1,2", findDuplicates(num));
    }

    @Test
    public void verifyHappyPathEdgeCase() {
    int[] num = new int[] { 1, 2, 3, 1, 1, 4, 3 };
    assertEquals("1,3", findDuplicates(num));
    }

    @Test
    public void verifyNullCase() {
    int[] num = null;
    assertEquals("Input Array Cannot be Null", findDuplicates(num));
    }

    @Test
    public void verifyEmptyCase() {
    int[] num = new int[0];
    assertEquals("Input Array Cannot be Empty", findDuplicates(num));
    }

    @Test
    public void verifySingleElementCase() {
    int[] num = new int[] { 4 };
    assertEquals("Input Array contains only one element", findDuplicates(num));
    }

    @Test
    public void verifyNoDuplicates() {
    int[] num = new int[] { 1, 2, 3, 4 };
    assertEquals("Input Array has No Duplicate Elements", findDuplicates(num));
    }
}
