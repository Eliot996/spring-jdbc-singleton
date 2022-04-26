package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.IRepository;

import java.util.List;

public class DepartmentService {
    IRepository<Department> repo = new DepartmentRepository();

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

    public void setRepo(IRepository<Department> repo) {
        this.repo = repo;
    }
}
