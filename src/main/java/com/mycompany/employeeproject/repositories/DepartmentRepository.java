package com.mycompany.employeeproject.repositories;

import com.mycompany.employeeproject.connector.DataBaseConnector;
import org.apache.log4j.Logger;
import com.mycompany.employeeproject.model.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private final Logger LOGGER = Logger.getLogger(DepartmentRepository.class);

    public List<Department> getAllDepartments(){
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT id, name_dep, description FROM departments ORDER BY id";
        
        try(Connection con = DataBaseConnector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name_dep");
                String disc = rs.getString("description");
                departments.add(new Department(id, name, disc));
            }
        }catch (SQLException e){
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return departments;
    }

    public Department getDepartmentByName(String nameDep){
        String sql = "SELECT id, name_dep, description FROM departments WHERE name_dep like ?";
        Department result = new Department();
        
        try(Connection con = DataBaseConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){

            stmt.setString(1, nameDep);
            try(ResultSet rs = stmt.executeQuery()){
               if (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name_dep");
                    String disc = rs.getString("description");
                    result.setId(id);
                    result.setDepartmmentName(name);
                    result.setDescription(disc);
                } 
            }catch(Exception ex){
                throw new Exception(ex);
            }
        }catch (Exception e){
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return result;
    }

    public int addDepartment(Department dep){
        String sql = "INSERT INTO departments(name_dep, description) VALUES(?, ?) RETURNING id";
        int result = 0;
        
        try(Connection con = DataBaseConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){

            stmt.setString(1, dep.getDepartmmentName());
            stmt.setString(2, dep.getDescription());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getInt("id");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return result;
    }

    public boolean updateDepartment(Department dep){
        String sql = "UPDATE departments SET name_dep = ?, description = ? WHERE id = ?";
        boolean result = false;
        
        try(Connection con = DataBaseConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){

            stmt.setString(1, dep.getDepartmmentName());
            stmt.setString(2, dep.getDescription());
            stmt.setInt(3, dep.getId());
            int res = stmt.executeUpdate();
            
            if(res > 0){
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return result;
    }

    public boolean deleteDepartment(int id){
        String sql = "DELETE FROM departments WHERE id = ?";
        boolean result = false;
        try(Connection con = DataBaseConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, id);
            int res = stmt.executeUpdate();

            if(res > 0){
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return result;
    }
}