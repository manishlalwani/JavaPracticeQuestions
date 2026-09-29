package org.practice.questions;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.Arrays;

public class Employee {
    String name;
    double salary;
    String deptName;

    public Employee(String name, double salary, String deptName) {
        this.name = name;
        this.salary = salary;
        this.deptName = deptName;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getName() {

        return this.name;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public static Employee[] sortEmployeeOnName(Employee[] employees) {
        Arrays.sort(employees, Comparator.comparing(Employee::getName));
        return employees;
    }

    public static Employee[] sortEmployeeOnSalary(Employee[] employees) {
        Arrays.sort(employees, Comparator.comparing(Employee::getSalary));
        return employees;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("manish", 1000, "QA");
        Employee e2 = new Employee("ravin", 2000, "Dev");
        Employee e3 = new Employee("manjul", 3000, "PM");
        Employee[] employees = new Employee[] { e1, e2, e3 };
        Employee[] sortedEmployeesOnName = sortEmployeeOnName(employees);
        for (Employee emp : sortedEmployeesOnName) {
            System.out.println("Sort on the Name");
            System.out.println("Emp Name is "+ emp.getName() + "and salary is "+ emp.getSalary());
        }

        Employee[] sortedEmployeesOnSalary = sortEmployeeOnSalary(employees);
        for (Employee emp : sortedEmployeesOnSalary) {
            System.out.println("Sort on the Salary");
            System.out.println("Emp Name is "+ emp.getName() + "and salary is "+ emp.getSalary());
        }
    }
}
