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
        // run through the list of employees and add to a hashmap<DepartmentNumber, amount> or use double Arraylist
        // return the department with the most employees.

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

    public void setRepo(IRepository<Department> repo) {
        this.repo = repo;
    }

    public void setEmployeeRepo(IRepository<Employee> employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
}
