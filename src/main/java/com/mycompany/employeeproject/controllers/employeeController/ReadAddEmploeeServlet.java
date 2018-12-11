package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.pgAPI.EmployeeWithDepartmentRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadAddEmployeeServlet", urlPatterns = {"/readAddEmployee"})
public class ReadAddEmploeeServlet extends HttpServlet {

    private final EmployeeWithDepartmentRepository empDep = new EmployeeWithDepartmentRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("modelEmployees", empDep.getAllEmployeeDepartments());
        request.getRequestDispatcher("readAddDepartment").include(request, response);
    }
}
