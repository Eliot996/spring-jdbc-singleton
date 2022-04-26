package com.example.demo.services;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    static EmployeeService ES = new EmployeeService();
    Employee e = new Employee();

    @BeforeAll
    static void prep() {
        ES.setRepo(new MockEmployeeRepo());
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