package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.pgAPI.DepartmentRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadAddDepartmentServlet", urlPatterns = {"/readAddDepartment"})
public class ReadAddDepartmentServlet extends HttpServlet {
    
    private final DepartmentRepository departments = new DepartmentRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("modelDepartments", departments.getAllDepartments());
        request.getRequestDispatcher("/home.jsp").include(request, response);
    }
}
