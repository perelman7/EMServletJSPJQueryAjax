package com.mycompany.employeeproject.controllers.employeeController;

import com.mycompany.employeeproject.model.Department;
import com.mycompany.employeeproject.pgAPI.DepartmentRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ReadAddDepartmentServlet", urlPatterns = {"/readAddDepartment"})
public class ReadAddDepartmentServlet extends HttpServlet {
    
    private final DepartmentRepository departments = new DepartmentRepository();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("modelDepartments", departments.getAllDepartments());
        Cookie cookie = new Cookie("SessionName", "Session1");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        request.getRequestDispatcher("/home.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("depName");
        String desc = request.getParameter("description");
        departments.addDepartment(new Department(name, desc));
        response.sendRedirect("readAddEmployee");
    }
}
