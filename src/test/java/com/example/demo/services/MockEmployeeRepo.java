package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.IRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockEmployeeRepo implements IRepository<Employee> {
    private final ArrayList<Employee> list = new ArrayList<>();
    @Override
    public boolean create(Employee entity) {
        list.add(entity);
        return true;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEntities() {
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
