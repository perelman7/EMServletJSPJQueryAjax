package com.mycompany.employeeproject.repositories;

import com.mycompany.employeeproject.connector.DataBaseConnector;
import com.mycompany.employeeproject.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

public class EmployeeRepository {

    private final Logger LOGGER = Logger.getLogger(EmployeeRepository.class);
    
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT id, name, surname, fathername, date_of_berth, dep_id FROM employees ORDER BY id";

        try(Connection con = DataBaseConnector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String fatherName = rs.getString("fathername");
                String dataOfBirthday = rs.getString("date_of_berth");
                int dep_id = rs.getInt("dep_id");
                employees.add(new Employee(id, surname, name, fatherName, dataOfBirthday, dep_id ));
            }
        }catch (SQLException e){
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return employees;
    }

    public int addEmployee(Employee emp){
        String sql = "INSERT INTO employees(name, surname, fathername, date_of_berth, dep_id) VALUES(?, ?, ?, ?, ?) RETURNING id";
        int result = 0;
        try(Connection con = DataBaseConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){

            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getSurname());
            stmt.setString(3, emp.getFatherName());
            stmt.setString(4, emp.getDataOfBirthday());
            stmt.setInt(5, emp.getDepartmentId());
            
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    result = rs.getInt("id");
                }
            }catch(Exception ex){
                throw new Exception("ResultSet exception: " + ex);
            }
        } catch (Exception e) {
            LOGGER.error("Exception or class drive is wrong, " + e.getMessage());
        }
        return result;
    }

    public boolean updateEmployee(Employee emp){
        String sql = "UPDATE employees SET name = ?, surname = ?, fathername = ?, date_of_berth = ?, dep_id = ? WHERE id = ?";
        boolean result = false;
        
        try(Connection con = DataBaseConnector.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getSurname());
            stmt.setString(3, emp.getFatherName());
            stmt.setString(4, emp.getDataOfBirthday());
            stmt.setInt(5, emp.getDepartmentId());
            stmt.setInt(6, emp.getId());
            
            int res = stmt.executeUpdate();
            if(res > 0){
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return result;
    }

    public boolean deleteEmployee(int id){
        String sql = "DELETE FROM employees WHERE id = ? ";
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