package org.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.practice.questions.Employee;

public class EmployeeTest {

    private List<Employee> employeeList;

    @BeforeEach
    public void setUp() {
        Employee e1 = new Employee("Manish", 1000, "QA");
        Employee e2 = new Employee("Deepika", 2000, "Dev");
        Employee e3 = new Employee("Shourya", 3000, "Admin");
        Employee e4 = new Employee("Atul", 4100, "QA");
        Employee e5 = new Employee("Anand", 4200, "Dev");
        employeeList = List.of(e1, e2, e3, e4, e5);
    }

    @Test
    public void verifyMaximumSalaryAndEmpName() {
        Employee highestEmployee = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();

        assertEquals("Anand", highestEmployee.getName());
        assertEquals(4200, highestEmployee.getSalary());
    }

    @Test
    public void verifyMaxiumSalaryEmpNameDeptQA() {
        assertEquals("Atul", employeeList.stream()
                .filter(e -> "QA".equalsIgnoreCase(e.getDeptName()))
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null).getName());
    }

    @Test
    public void verifySecondHighestSalary() {
        double secondHighest = employeeList.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        assertEquals(4100, secondHighest);
    }

}
