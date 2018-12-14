package com.mycompany.employeeproject.controllers.OAuth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "GoogleLogoutServlet", urlPatterns = {"/googleLogout"})
public class GoogleLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        try{
            session.removeAttribute("name");
            session.removeAttribute("email");
            session.removeAttribute("token");
            req.logout();
        }catch(Exception e){}
        
        resp.sendRedirect("/EmployeeProject/login.jsp");
    }
}
