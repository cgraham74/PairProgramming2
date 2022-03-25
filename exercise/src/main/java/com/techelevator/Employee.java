package com.techelevator;

import java.time.LocalDate;

public class Employee {
    private long employeeId = 0;
    private String firstname = "";
    private String lastname = "";
    private String email = "";
    private double salary = 0;
    private Department departments;
    private LocalDate hireDate;
    private static final double STARTING_SALARY = 60000;


    public Employee(long employeeId, String firstname, String lastname, String email, Department departments, LocalDate hireDate) {
        this.employeeId = employeeId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.departments = departments;
        this.hireDate = hireDate;
        this.salary = STARTING_SALARY;

    }
    public Employee (){

    }
    public String getFullName(){
        return lastname + ", " + firstname;
    }
    public double raiseSalary(double percent){
        return salary + (salary * (percent / 100));
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return departments;
    }

    public void setDepartment(Department department) {
        this.departments = department;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}

