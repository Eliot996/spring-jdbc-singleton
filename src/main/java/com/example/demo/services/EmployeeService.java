package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import com.example.demo.utilities.EmployeeValidationUtil;

import java.util.List;

public class EmployeeService {

    private final EmployeeValidationUtil EVU = new EmployeeValidationUtil();

    private double averageSalary;

    private IRepository<Employee> repo = new EmployeeRepository();

    public boolean hasAboveAverageSalary(Employee e) {
        if (e.getSalary() < 0) {
            throw new IllegalArgumentException("Salary is not a valid number");
        }

        return e.getSalary() > averageSalary;

    }

    public void setRepo(IRepository<Employee> repo) {
        this.repo = repo;
    }

    public void setAverageSalary() {
        List<Employee> list = repo.getAllEntities();

        int total = 0;

        for (Employee e : list) {
            total += e.getSalary();
        }

        averageSalary = (double) total / list.size();
    }
}
