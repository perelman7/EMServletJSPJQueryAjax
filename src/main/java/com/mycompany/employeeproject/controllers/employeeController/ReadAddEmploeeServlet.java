package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.model.Employee;
import com.mycompany.employeeproject.repositories.EmployeeRepository;
import com.mycompany.employeeproject.repositories.EmployeeWithDepartmentRepository;
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
    private final EmployeeRepository employees = new EmployeeRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("modelEmployees", empDep.getAllEmployeeDepartments());
        request.getRequestDispatcher("readAddDepartment").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String fatherName = request.getParameter("fatherName");
        String dataOfBirthday = request.getParameter("dataOfBirthday");
        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        int id = employees.addEmployee(new Employee(surname, name, fatherName, dataOfBirthday, departmentId));
        HttpSession session = request.getSession();
        if(id > 0){
            session.setAttribute("messageAddEmp", "Employee was added");
        }else{
            session.setAttribute("messageAddEmp", "Employee wasn`t added");
        }
        response.sendRedirect("readAddEmployee");
    }
}
