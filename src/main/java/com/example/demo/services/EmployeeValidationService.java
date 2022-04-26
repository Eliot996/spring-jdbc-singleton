package com.example.demo.services;

import com.example.demo.models.Employee;

public class EmployeeValidationService {

    public boolean isCommissionValid(Employee e) {
        if (e.getSalary() < 0) {
            throw new IllegalArgumentException("Salary is not a valid number");
        } else if (e.getCommission() < 0) {
            throw new IllegalArgumentException("Commission is not a valid number");
        }

        if (e.getCommission() <= e.getSalary()) {
            return true;
        }

        return false;
    }
}
