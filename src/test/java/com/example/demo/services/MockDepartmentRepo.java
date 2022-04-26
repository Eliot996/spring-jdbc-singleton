package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.repositories.IRepository;

import java.util.ArrayList;
import java.util.List;

public class MockDepartmentRepo implements IRepository<Department> {

    ArrayList<Department> list = new ArrayList<>();

    @Override
    public boolean create(Department entity) {
        list.add(entity);
        return true;
    }

    @Override
    public Department getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Department> getAllEntities() {
        return list;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
