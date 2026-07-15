package org.practice.questions;

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
}
