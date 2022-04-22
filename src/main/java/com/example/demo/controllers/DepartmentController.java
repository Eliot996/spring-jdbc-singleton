package com.example.demo.controllers;

import com.example.demo.models.Department;
import com.example.demo.repositories.IRepository;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentController {
    private IRepository<Department> departmentRepository = new DepartmentRepository();

    @GetMapping("/departments")
    public String allDepartments(Model model){
        model.addAttribute("departments", departmentRepository.getAllEntities());
        return "departments";
    }
}
