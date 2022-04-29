package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee> {

    @Override
    public boolean create(Employee entity) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO employees(`employee_name`, `job`, `commission`, `department_number`, `manager`, `salary`, `hiredate`) " +
                            "VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, entity.getEmployee_name());
            pstmt.setString(2, entity.getJob());
            pstmt.setInt(3, entity.getCommission());
            pstmt.setInt(4, entity.getDepartment_number());
            pstmt.setInt(5, entity.getManager());
            pstmt.setInt(6, entity.getSalary());
            pstmt.setDate(7, Date.valueOf(LocalDate.now()));

            pstmt.execute();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();


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
                return temp;
            }

            return null;
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
            e.printStackTrace();
        }
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

    public List<Employee> getAllEntitiesByDepartment(String department) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT employees.* \n" +
                    "FROM employees\n" +
                    "INNER JOIN departments ON employees.department_number = departments.department_number\n" +
                    "WHERE departments.department_name = ?");

            pstmt.setString(1, department);

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
