package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.pgAPI.EmployeeWithDepartmentRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ReadAddEmployeeServlet", urlPatterns = {"/readAddEmployee"})
public class ReadAddEmploeeServlet extends HttpServlet {

    private final EmployeeWithDepartmentRepository empDep = new EmployeeWithDepartmentRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String s = session.getId();
        session.setAttribute("modelEmployees", empDep.getAllEmployeeDepartments());
        request.getRequestDispatcher("readAddDepartment").include(request, response);
    }
}
