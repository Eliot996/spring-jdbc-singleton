package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.repositories.IRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private static final IRepository<Department> MDR = new MockDepartmentRepo();
    private static final DepartmentService DS = new DepartmentService();

    @BeforeAll
    public static void prep() {
        MDR.create(new Department(40, "name", "location"));
        MDR.create(new Department(50, "name", "location"));

        DS.setRepo(MDR);
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
}