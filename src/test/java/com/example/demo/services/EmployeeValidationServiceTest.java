package com.example.demo.services;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeValidationServiceTest {

    Employee e = new Employee();
    EmployeeValidationService EVS = new EmployeeValidationService();

    @Test
    void isCommissionValid_invalidSalary() {
        // Arrange
        e.setSalary(-1);
        e.setCommission(0);

        String expected = "Salary is not a valid number";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EVS.isCommissionValid(e);
        });

        String actual = exception.getMessage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isCommissionValid_invalidCommission() {
        // Arrange
        e.setSalary(1);
        e.setCommission(-1);

        String expected = "Commission is not a valid number";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EVS.isCommissionValid(e);
        });

        String actual = exception.getMessage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isCommissionValid_equalSalaryAndCommission() {
        // Arrange
        e.setSalary(1);
        e.setCommission(1);

        boolean expected = true;

        // Act
        boolean actual = EVS.isCommissionValid(e);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isCommissionValid_SalaryLessThanCommission() {
        // Arrange
        e.setSalary(1);
        e.setCommission(2);

        boolean expected = false;

        // Act
        boolean actual = EVS.isCommissionValid(e);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void isCommissionValid_SalaryGreaterThanCommission() {
        // Arrange
        e.setSalary(2);
        e.setCommission(1);

        boolean expected = true;

        // Act
        boolean actual = EVS.isCommissionValid(e);

        // Assert
        assertEquals(expected, actual);
    }


}