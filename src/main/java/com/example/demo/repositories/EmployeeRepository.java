package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee> {

    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEntities() {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");

            ResultSet rs = pstmt.executeQuery();

            ArrayList<Employee> allEmployees = new ArrayList<>();
            while(rs.next()){
                //Indsætte i en liste
                Employee temp = new Employee(
                        rs.getInt("id"),
                        rs.getInt("commission"),
                        rs.getInt("department_number"),
                        rs.getInt("manager"),
                        rs.getInt("salary"),
                        rs.getDate("hiredate"),
                        rs.getString("employee_name"),
                        rs.getString("job")
                );
                allEmployees.add(temp);
            }

            return allEmployees;
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
