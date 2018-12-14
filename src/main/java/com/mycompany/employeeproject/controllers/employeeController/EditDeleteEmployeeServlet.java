package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.model.Employee;
import com.mycompany.employeeproject.repositories.EmployeeRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditDeleteEmployeeServlet", urlPatterns = {"/editDeleteEmployee"})
public class EditDeleteEmployeeServlet extends HttpServlet {

    private final EmployeeRepository employees = new EmployeeRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean res = employees.deleteEmployee(id);
        HttpSession session = request.getSession();
        if(res){
            session.setAttribute("messageDelEmp", "Employee was deleted");
        }else{
            session.setAttribute("messageDelEmp", "Employee wasn`t deleted");
        }
        response.sendRedirect("readAddEmployee");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String fatherName = request.getParameter("fatherName");
        String dataOfBirthday = request.getParameter("dataOfBirthday");
        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        boolean res = employees.updateEmployee(new Employee(id, surname, name, fatherName, dataOfBirthday, departmentId));
        HttpSession session = request.getSession();
        if(res){
            session.setAttribute("messageEditEmp", "Employee was updated");
        }else{
            session.setAttribute("messageEditEmp", "Employee wasn`t updated");
        }
        response.sendRedirect("readAddEmployee");
    }
}
