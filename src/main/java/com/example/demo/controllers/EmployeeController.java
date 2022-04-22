package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    private final IRepository<Employee> employeeRepository = new EmployeeRepository();
    @GetMapping("/employees")
    public String getAllEmployees(Model model) {

        model.addAttribute("employees", employeeRepository.getAllEntities());
        return "employees";
    }

    @GetMapping("/employee")
    public String getEmployee(Model model, @RequestParam int id) {

        model.addAttribute("employee", employeeRepository.getSingleEntityById(id));
        return "employee";
    }
}
