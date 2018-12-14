/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.model.Department;
import com.mycompany.employeeproject.repositories.DepartmentRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditDeleteDepartmentServlet", urlPatterns = {"/editDeleteDepartment"})
public class EditDeleteDepartmentServlet extends HttpServlet {

    private final DepartmentRepository departments = new DepartmentRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean res = departments.deleteDepartment(id);
        HttpSession session = request.getSession();
        if(res){
            session.setAttribute("messageDelDep", "Department was deleted");
        }else{
            session.setAttribute("messageDelDep", "Department wasn`t deleted");
        }
        response.sendRedirect("readAddEmployee");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameDep");
        String desc = request.getParameter("description");
        boolean res = departments.updateDepartment(new Department(id, name, desc));
        HttpSession session = request.getSession();
        if(res){
            session.setAttribute("messageEditDep", "Department was updated");
        }else{
            session.setAttribute("messageEditDep", "Department wasn`t updated");
        }
        response.sendRedirect("readAddEmployee");
    }
}
