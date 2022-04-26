package com.example.demo.services;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private static final MockEmployeeRepo MER = new MockEmployeeRepo();
    private static final EmployeeService ES = new EmployeeService();
    Employee e = new Employee();

    @BeforeAll
    static void prep() {

        MER.create(new Employee(0, 0, 0, 0, 8, new Date(), "name", "job"));
        MER.create(new Employee(1, 0, 0, 0, 9, new Date(), "name", "job"));
        MER.create(new Employee(2, 0, 0, 0, 10, new Date(), "name", "job"));
        MER.create(new Employee(3, 0, 0, 0, 11, new Date(), "name", "job"));
        MER.create(new Employee(4, 0, 0, 0, 12, new Date(), "name", "job"));

        ES.setRepo(MER);

        // average should be 10
        ES.setAverageSalary();
    }

    @Test
    void hasAboveAverageSalary_invalidSalary() {
        // Arrange
        e.setSalary(-1);
        e.setCommission(0);

        String expected = "Salary is not a valid number";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ES.hasAboveAverageSalary(e);
        });

        String actual = exception.getMessage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void hasAboveAverageSalary_hasHigherSalary() {
        // Arrange
        e.setSalary(11);

        boolean expected = true;

        // Act
        boolean actual = ES.hasAboveAverageSalary(e);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void hasAboveAverageSalary_HasLowerSalary() {
        // Arrange
        e.setSalary(9);

        boolean expected = false;

        // Act
        boolean actual = ES.hasAboveAverageSalary(e);

        // Assert
        assertEquals(expected, actual);
    }
}