package org.practice;

public class Employee2 {

    // Clarify - Employee Should be Sorted by Salary in Ascending or Descending
    // order - Lets Say in Ascending

    // Create Employee Class

    protected String empName;
    protected double salary;

    public Employee2(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getEmpName() {
        return this.empName;
    }

    @Override
    public String toString() {
        return this.empName + ": $" + this.salary;
    }
}
