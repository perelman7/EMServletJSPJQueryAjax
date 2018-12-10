package com.mycompany.employeeproject.controllers;

import com.mycompany.employeeproject.model.Department;
import com.mycompany.employeeproject.model.EmployeeDepartmentList;
import com.mycompany.employeeproject.model.EmployeeWithDepartment;
import com.mycompany.employeeproject.pgAPI.DepartmentRepository;
import com.mycompany.employeeproject.pgAPI.EmployeeWithDepartmentRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    private final EmployeeWithDepartmentRepository empDep = new EmployeeWithDepartmentRepository();
    private final DepartmentRepository departments = new DepartmentRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Department> deps = departments.getAllDepartments();
        List<EmployeeWithDepartment> empDepsList = empDep.getAllEmployeeDepartments();
        EmployeeDepartmentList list = new EmployeeDepartmentList();
        list.setEmpDeps(empDepsList);
        list.setDepartments(deps);
        if(deps.size() > 0 && empDepsList.size() > 0){
            request.setAttribute("list", list);
        }else{
            response.getWriter().write("Resources don't find (Exception 404)");
            response.setStatus(404);
        }
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
