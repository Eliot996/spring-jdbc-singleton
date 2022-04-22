package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  DepartmentRepository implements IRepository<Department> {
    @Override
    public boolean create(Department entity) {
        return false;
    }

    @Override
    public Department getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Department> getAllEntities() {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departments");

            ResultSet rs = pstmt.executeQuery();

            ArrayList<Department> allDepartments = new ArrayList<>();
            while(rs.next()){
                //Indsætte i en liste
                Department temp = new Department(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                allDepartments.add(temp);
            }

            return allDepartments;
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
