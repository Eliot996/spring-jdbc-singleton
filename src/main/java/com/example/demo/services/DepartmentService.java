package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    IRepository<Department> repo = new DepartmentRepository();
    IRepository<Employee> employeeRepo = new EmployeeRepository();

    public int getHighestDepartmentNumber() {
        List<Department> list = repo.getAllEntities();

        int highest = 0;

        for (Department d : list) {
            if (d.getDeptno() > highest) {
                highest = d.getDeptno();
            }
        }
        return highest;
    }

    public int getDepartmentNumberWithMostEmployees() {
        List<Employee> list = employeeRepo.getAllEntities();
        ArrayList<Integer> departments = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();

        int dep_num;
        for (Employee e : list) {
            dep_num = e.getDepartment_number();
            if (departments.contains(dep_num)) {
                amount.set(departments.indexOf(dep_num), amount.get(departments.indexOf(dep_num)) + 1);
            } else {
                departments.add(dep_num);
                amount.add(1);
            }
        }

        int mostEmployees = 0;

        for (int i : amount) {
            if (i > mostEmployees) {
                mostEmployees = i;
            }
        }

        return departments.get(amount.indexOf(mostEmployees));
    }

    public int getDepartmentNumberWithHighestAverageSalary() {
        List<Employee> list = employeeRepo.getAllEntities();
        ArrayList<Integer> departments = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        ArrayList<Double> salary = new ArrayList<>();

        int dep_num;
        for (Employee e : list) {
            dep_num = e.getDepartment_number();
            if (departments.contains(dep_num)) {
                amount.set(departments.indexOf(dep_num), amount.get(departments.indexOf(dep_num)) + 1);
                salary.set(departments.indexOf(dep_num), salary.get(departments.indexOf(dep_num)) + e.getSalary());
            } else {
                departments.add(dep_num);
                amount.add(1);
                salary.add((double) e.getSalary());
            }
        }

        for (int i = 0; i < departments.size(); i++) {
            salary.set(i, salary.get(i) / amount.get(i));
        }

        double highestAverageSalary = 0;

        for (double i : salary) {
            if (i > highestAverageSalary) {
                highestAverageSalary = i;
            }
        }

        return departments.get(salary.indexOf(highestAverageSalary));
    }

    public void setRepo(IRepository<Department> repo) {
        this.repo = repo;
    }

    public void setEmployeeRepo(IRepository<Employee> employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
}
