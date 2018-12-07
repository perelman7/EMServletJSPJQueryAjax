package com.mycompany.employeeproject.controllers;

import com.google.gson.Gson;
import com.mycompany.employeeproject.pgAPI.DepartmentRepository;
import com.mycompany.employeeproject.model.AjaxResponse;
import com.mycompany.employeeproject.model.Department;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DepartmentControllerServlet extends HttpServlet {

    private final DepartmentRepository departments = new DepartmentRepository();
    private final Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> deps = departments.getAllDepartments();
        if(deps.size() > 0){
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(deps));
        }else{
            resp.setStatus(404);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("departmmentName");
        String desc = req.getParameter("description");
        if(name.trim().isEmpty() || id <= 0){
            resp.setStatus(400);
        }else{
            boolean result = departments.update(new Department(id, name, desc));
            AjaxResponse ajaxResp = new AjaxResponse(0, "Department was not update successful");

            if(result){
                ajaxResp.setStatus(1);
                ajaxResp.setMessage("Department was updated successful");
            }else{
                resp.setStatus(404);
            }
            resp.getWriter().write(gson.toJson(ajaxResp));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        if(id <= 0){
            resp.setStatus(400);
        }else{
            boolean result = departments.delete(id);
            AjaxResponse ajaxResp = new AjaxResponse(0, "Department was not deleted successful");

            if(result){
                ajaxResp.setStatus(1);
                ajaxResp.setMessage("Department was deleted successful");
            }else{
                resp.setStatus(404);
            }
            resp.getWriter().write(gson.toJson(ajaxResp));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("departmmentName");
        String desc = req.getParameter("description");
        
        if(name.trim().isEmpty()){
            resp.setStatus(400);
        }else{
            int res = departments.addDepartment(new Department(name, desc));
            AjaxResponse ajaxResp = new AjaxResponse(0, "Department was not added successfuly");

            if(res > 0){
                ajaxResp.setStatus(1);
                ajaxResp.setMessage("Department was added successful");
                ajaxResp.setIdElem(res);
            }else{
                resp.setStatus(404);
            }
            resp.getWriter().write(gson.toJson(ajaxResp));
        }
    }
}
