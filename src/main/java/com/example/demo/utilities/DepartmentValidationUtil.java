package com.example.demo.utilities;

public class DepartmentValidationUtil {

    public boolean validateDepartmentNumber (int number) {

        if (number < 10 || number > 999) {
            return false;
        } else if (number % 10 != 0) {
            return false;
        }

        return true;
    }
}
