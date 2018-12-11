/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.model.Department;
import com.mycompany.employeeproject.model.Employee;
import com.mycompany.employeeproject.pgAPI.DepartmentRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditDeleteDepartmentServlet", urlPatterns = {"/editDeleteDepartment"})
public class EditDeleteDepartmentServlet extends HttpServlet {

    private final DepartmentRepository departments = new DepartmentRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        departments.deleteDepartment(id);
        response.sendRedirect("readAddEmployee");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameDep");
        String desc = request.getParameter("description");
        departments.updateDepartment(new Department(id, name, desc));
        response.sendRedirect("readAddEmployee");
    }

}
