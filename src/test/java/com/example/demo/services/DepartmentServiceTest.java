package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.repositories.IRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private static final IRepository<Department> MDR = new MockDepartmentRepo();
    private static final MockEmployeeRepo MER = new MockEmployeeRepo();
    private static final DepartmentService DS = new DepartmentService();

    @BeforeAll
    public static void prep() {
        // create mock employees
        MER.create(new Employee(0, 0, 40, 0, 8, new Date(), "name", "job"));
        MER.create(new Employee(1, 0, 40, 0, 9, new Date(), "name", "job"));
        MER.create(new Employee(2, 0, 40, 0, 10, new Date(), "name", "job"));
        MER.create(new Employee(3, 0, 50, 0, 11, new Date(), "name", "job"));
        MER.create(new Employee(4, 0, 50, 0, 12, new Date(), "name", "job"));

        // create mock departments
        MDR.create(new Department(40, "name", "location"));
        MDR.create(new Department(50, "name", "location"));

        DS.setRepo(MDR);
        DS.setEmployeeRepo(MER);
    }

    @Test
    void getHighestDepartmentNumber() {
        // Arrange
        int expected = 50;

        // Act
        int actual = DS.getHighestDepartmentNumber();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getDepartmentNumberWithMostEmployees() {
        // Arrange
        int expected = 40;

        // Act
        int actual = DS.getDepartmentNumberWithMostEmployees();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getDepartmentNumberWithHighestAverageSalary() {
        // Arrange
        int expected = 50;

        // Act
        int actual = DS.getDepartmentNumberWithHighestAverageSalary();

        // Assert
        assertEquals(expected, actual);
    }
}