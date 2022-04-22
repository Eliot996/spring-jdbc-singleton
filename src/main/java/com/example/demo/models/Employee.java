package com.example.demo.models;

import java.util.Date;

public class Employee {
    private int id, commission, department_number, manager, salary;
    private Date hireDate;
    private String employee_name, job;

    public Employee(int id, int commission, int department_number, int manager, int salary, Date hiredate, String employee_name, String job) {
        this.id = id;
        this.commission = commission;
        this.department_number = department_number;
        this.manager = manager;
        this.salary = salary;
        this.hireDate = hiredate;
        this.employee_name = employee_name;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public int getCommission() {
        return commission;
    }

    public int getDepartment_number() {
        return department_number;
    }

    public int getManager() {
        return manager;
    }

    public int getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getJob() {
        return job;
    }
}
