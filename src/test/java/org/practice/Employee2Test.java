// package org.practice;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.Comparator;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;

// public class Employee2Test {

//     private Employee2 empListTest = (Employee2) List.of("Manish", 2000, "Atul", 3000, "Dinesh", 5000, "Angad", 7000);

//     @Test // Consider Descending Order of Salary needs to be Verified
//     public void verifyDescendingEmployeeTest() {
//         // Use Stream API
//         Employee2 expectedList = (Employee2) List.of("Angad", 7000, "Dinesh", 5000, "Atul", 3000, "Manish", 2000);
//         assertEquals(expectedList, sortEmployeeDescendingOnSalary(empListTest));
//     }

//     @Test
//     public void verifyDescendingEmployeeTestForNullEmployee() {
//         Employee2 empList = (Employee2) List.of("Manish", 2000, null);
//         assertThrows(empList.getClass());
//     }

//     // Time Complexity is O(nlogn) because of sorting logic
//     public static List<Employee2> sortEmployeeDescendingOnSalary(Employee2 empListTest2){
//             //Handle Null Employee
//             for(Employee2 emp : empListTest2){
//                 if(emp == null){
//                     return empListTest2 new throw "Null Employee";
//                 }
//             }
//             return ((List) empListTest2.stream()
//                             .sorted(Comparator.comparing(Employee2::getSalary))) //Understand Comparator as it gives Sorting logic
//                             .reversed()
//                             .collect(Collectors.toList());
//         }

// }
