package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentValidationServiceTest {

    DepartmentValidationService DVS = new DepartmentValidationService();

    @Test
    void validateDepartmentNumber_lessThan0() {
        // Arrange
        int testNumber = -1;

        boolean expected = false;

        // Act
        boolean actual = DVS.validateDepartmentNumber(testNumber);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void validateDepartmentNumber_lessThan10() {
        // Arrange
        int testNumber = 1;

        boolean expected = false;

        // Act
        boolean actual = DVS.validateDepartmentNumber(testNumber);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void validateDepartmentNumber_moreThan999() {
        // Arrange
        int testNumber = 1000;

        boolean expected = false;

        // Act
        boolean actual = DVS.validateDepartmentNumber(testNumber);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void validateDepartmentNumber_notDivisibleBy10() {
        // Arrange
        int testNumber = 11;

        boolean expected = false;

        // Act
        boolean actual = DVS.validateDepartmentNumber(testNumber);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void validateDepartmentNumber_divisibleBy10() {
        // Arrange
        int testNumber = 10;

        boolean expected = true;

        // Act
        boolean actual = DVS.validateDepartmentNumber(testNumber);

        // Assert
        assertEquals(expected, actual);
    }


}