package com.mycompany.employeeproject.controllers;

import com.google.gson.Gson;
import com.mycompany.employeeproject.pgAPI.EmployeeRepository;
import com.mycompany.employeeproject.model.AjaxResponse;
import com.mycompany.employeeproject.model.Employee;
import com.mycompany.employeeproject.model.EmployeeWithDepartment;
import com.mycompany.employeeproject.pgAPI.EmployeeWithDepartmentRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeControllerServlet extends HttpServlet {

    private final EmployeeRepository employees = new EmployeeRepository();
    private final EmployeeWithDepartmentRepository employeesWithDepartment = new EmployeeWithDepartmentRepository();
    private final Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<EmployeeWithDepartment> emps = employeesWithDepartment.getAllEmployeeDepartments();
        if(emps.size() > 0){
            response.setContentType("application/json");
            response.getWriter().write(gson.toJson(emps));
        }else{
            response.setStatus(404);
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String fatherName = req.getParameter("fatherName");
        String dataOfBirthday = req.getParameter("dataOfBirthday");
        int dep_id = Integer.parseInt(req.getParameter("dep_id"));
        if(surname.trim().isEmpty() || name.trim().isEmpty() || dep_id <= 0){
            resp.setStatus(400);
        }else{
            boolean result = employees.updateEmployee(new Employee(id, surname, name, fatherName, dataOfBirthday, dep_id));
            AjaxResponse ajaxResp = new AjaxResponse(0, "Employee was not update successful");
            if(result){
                ajaxResp.setStatus(1);
                ajaxResp.setMessage("Employee was updated successful");
            }else{
                resp.setStatus(404);
            }
            resp.getWriter().write(gson.toJson(ajaxResp));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        
        if(id < 0){
            resp.setStatus(400);
        }else{
            boolean result = employees.deleteEmployee(id);
            AjaxResponse ajaxResp = new AjaxResponse(0, "Employee was not deleted successful");

            if(result){
                ajaxResp.setStatus(1);
                ajaxResp.setMessage("Employee was deleted successful");
            }else{
                resp.setStatus(404);
            }
            resp.getWriter().write(gson.toJson(ajaxResp));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String fatherName = req.getParameter("fatherName");
        String dataOfBirthday = req.getParameter("dataOfBirthday");
        int dep_id = Integer.parseInt(req.getParameter("departmentName"));
        
        if(surname.trim().isEmpty() || name.trim().isEmpty() || dep_id <= 0){
            resp.setStatus(400);
        }else{
            int res = employees.addEmployee(new Employee(surname, name, fatherName, dataOfBirthday, dep_id));
            AjaxResponse ajaxResp = new AjaxResponse(0, "Employee was not added successful", 0);
            if(res > 0){
                ajaxResp.setStatus(1);
                ajaxResp.setMessage("Employee was added successful");
                ajaxResp.setIdElem(res);
            }else{
                resp.setStatus(404);
            }
            resp.getWriter().write(gson.toJson(ajaxResp));
        }
    }
}
