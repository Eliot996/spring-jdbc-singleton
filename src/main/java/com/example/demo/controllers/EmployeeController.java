package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/employee_by_department")
    public String getEmployee(Model model, @RequestParam String department) {

        EmployeeRepository ER = (EmployeeRepository) employeeRepository;

        System.out.println(ER.getAllEntitiesByDepartment(department));

        model.addAttribute("employees", ER.getAllEntitiesByDepartment(department));
        return "employees";
    }

    @GetMapping("/create-employee")
    public String getCreateEmployee(Model model) {

        model.addAttribute("employee", new Employee());

        return "create-employee";
    }

    @PostMapping("/create-employee")
    public String createEmployee(Model model, @ModelAttribute Employee employee) {

        employeeRepository.create(employee);

        return "redirect:/employees";
    }
}
