package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.IRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockEmployeeRepo implements IRepository<Employee> {
    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEntities() {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(0, 0, 0, 0, 8, new Date(), "name", "job"));
        list.add(new Employee(1, 0, 0, 0, 9, new Date(), "name", "job"));
        list.add(new Employee(2, 0, 0, 0, 10, new Date(), "name", "job"));
        list.add(new Employee(3, 0, 0, 0, 11, new Date(), "name", "job"));
        list.add(new Employee(4, 0, 0, 0, 12, new Date(), "name", "job"));

        return list;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
