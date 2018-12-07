package com.mycompany.employeeproject.pgAPI;

import connector.DataBaseConnector;
import com.mycompany.employeeproject.model.EmployeeWithDepartment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

public class EmployeeWithDepartmentRepository {

    private final Logger LOGGER = Logger.getLogger(EmployeeWithDepartmentRepository.class);

    public List<EmployeeWithDepartment> getAllEmployeeDepartments(){
        List<EmployeeWithDepartment> employees = new ArrayList<>();
        String sql = "select e.id, e.name, e.surname, e.fathername, e.date_of_berth, d.id as departmentId, d.name_dep from employees as e \n" +
                        "join departments as d on (e.dep_id = d.id) order by id";

        try(Connection con = DataBaseConnector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String fatherName = rs.getString("fathername");
                String dataOfBirthday = rs.getString("date_of_berth");
                int dep_id = rs.getInt("departmentId");
                String dep_name = rs.getString("name_dep");

                employees.add(new EmployeeWithDepartment(id, surname, name, fatherName, dataOfBirthday, dep_id, dep_name));
            }
        }catch (SQLException e){
            LOGGER.error("SQL Exception or class drive is wrong, " + e.getMessage());
        }
        return employees;
    }
}
