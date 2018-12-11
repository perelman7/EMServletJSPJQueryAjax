<%@page import="java.util.Enumeration"%>
<%@page import="com.mycompany.employeeproject.model.EmployeeWithDepartment"%>
<%@page import="com.mycompany.employeeproject.model.Department"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous"/>
    </head>
    <body>
        <%
            List<EmployeeWithDepartment> employees = (List<EmployeeWithDepartment>) session.getAttribute("modelEmployees");
            List<Department> departments = (List<Department>) session.getAttribute("modelDepartments");

            int currentPageEmp = 1;
            int maxPagesEmp = (int) Math.ceil(employees.size() / 10.0);
            int currentPageDep = 1;
            int maxPagesDep = (int) Math.ceil(departments.size() / 10.0);
            int editEmployeeId = 0;
            int editDepartmentId = 0;
            try {
                if (Integer.parseInt(request.getParameter("currentPageEmp")) > maxPagesEmp) {
                    currentPageEmp = maxPagesEmp;
                } else if (Integer.parseInt(request.getParameter("currentPageEmp")) < 1) {
                    currentPageEmp = 1;
                } else if (request.getParameter("currentPageEmp") != null || !request.getParameter("currentPageEmp").isEmpty()) {
                    currentPageEmp = Integer.parseInt(request.getParameter("currentPageEmp"));
                }
            } catch (Exception e) {}
            try {
                if (Integer.parseInt(request.getParameter("currentPageDep")) > maxPagesDep) {
                    currentPageDep = maxPagesDep;
                } else if (Integer.parseInt(request.getParameter("currentPageDep")) < 1) {
                    currentPageDep = 1;
                } else if (request.getParameter("currentPageDep") != null || !request.getParameter("currentPageDep").isEmpty()) {
                    currentPageDep = Integer.parseInt(request.getParameter("currentPageDep"));
                }
            } catch (Exception e) {}
            try {
                if (request.getParameter("editEmployeeId") != null || !request.getParameter("editEmployeeId").isEmpty()) {
                    editEmployeeId = Integer.parseInt(request.getParameter("editEmployeeId"));
                }
            } catch (Exception e) {}
            try {
                if (request.getParameter("editDepartmentId") != null || !request.getParameter("editDepartmentId").isEmpty()) {
                    editDepartmentId = Integer.parseInt(request.getParameter("editDepartmentId"));
                }
            } catch (Exception e) {}
            int beginEmp = 10 * (currentPageEmp - 1);
            int endEmp = 10 + 10 * (currentPageEmp - 1);;
            if (endEmp > employees.size()) {
                endEmp = employees.size();
            }
            int beginDep = 10 * (currentPageDep - 1);
            int endDep = 10 + 10 * (currentPageDep - 1);
            if (endDep > employees.size()) {
                endDep = departments.size();
            }
        %>
        <div class="container-fluid">
            <div class="row">
                <h1>Home JSP!</h1>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <a class="btn btn-outline-primary" href="forms/departmentForm.jsp">Add Department</a>
                    <table class="table table-bordered table-sm table-hover">
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Name</td>
                                <td>Description</td>
                                <td colspan="2">Actions</td>
                            </tr>
                        </thead>

                        <tbody><%
                            for (int i = beginDep; i < endDep; i++) {
                                if(editDepartmentId == departments.get(i).getId()){
                                    %><tr><form action="editDeleteDepartment" method="post"><%
                                        %><input type="hidden" name="id" value="<% out.print(departments.get(i).getId());%>"/><%
                                        %><td><% out.print(departments.get(i).getId());%></td><%
                                        %><td><input type="text" name="nameDep" value="<% out.print(departments.get(i).getDepartmmentName());%>"/></td><%
                                        %><td><input type="text" name="description" value="<% out.print(departments.get(i).getDescription());%>"/></td><%
                                        %><td><a class="btn btn-outline-dark" href="?editDepartmentId=0">Cancel</a></td><%
                                        %><td><input class="btn btn-outline-success" type="submit" value="Save"/></td><%
                                    %></form></tr><%
                                }else{
                                    %><tr><%
                                        %><td><% out.print(departments.get(i).getId());%></td><%
                                        %><td><% out.print(departments.get(i).getDepartmmentName());%></td><%
                                        %><td><% out.print(departments.get(i).getDescription());%></td><%
                                        %><td><form action="editDeleteDepartment" method="get">
                                            <input type="hidden" name="id" value="<% out.print(departments.get(i).getId());%>"/>
                                            <input class="btn btn-outline-danger" type="submit" value="Delete"/>
                                        </form></td><%
                                        %><td><a class="btn btn-outline-warning" href="?editDepartmentId=<% out.print(departments.get(i).getId()); %>&currentPageEmp=<% out.print(currentPageEmp); %>&currentPageDep=<% out.print(currentPageDep); %>">Edit</a></td><%
                                    %></tr><%
                                }
                            }
                            %></tbody><%
                            editDepartmentId = 0;
                    %></table>
                    <a style="float: left;" class="page-link" href="/EmployeeProject/readAddEmployee?currentPageEmp=<% out.print(currentPageEmp); %>&currentPageDep=<% out.print(currentPageDep - 1); %>"><-</a>
                    <div style="float: left;"  class="page-link"><% out.print(currentPageDep); %> / <% out.print(maxPagesDep); %></div>
                    <a style="float: left;" class="page-link" href="/EmployeeProject/readAddEmployee?currentPageEmp=<% out.print(currentPageEmp); %>&currentPageDep=<% out.print(currentPageDep + 1); %>">-></a>
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-6">
                    <a class="btn btn-outline-primary" href="forms/employeeForm.html">Add Employee</a>
                    <table class="table table-bordered table-sm table-hover">
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Surname</td>
                                <td>Name</td>
                                <td>Father name</td>
                                <td>Date of birth</td>
                                <td>Department</td>
                                <td colspan="2">Actions</td>
                            </tr>
                        </thead>
                        <tbody><%
                            for (int i = beginEmp; i < endEmp; i++) {
                                if (editEmployeeId == employees.get(i).getId()) {
                                    %><tr><form action="editDeleteEmployee" method="post"><%
                                        %><input type="hidden" name="id" value="<% out.print(employees.get(i).getId());%>"/><%
                                        %><td><% out.print(employees.get(i).getId());%></td><%
                                        %><td><input type="text" name="surname" value="<% out.print(employees.get(i).getSurname());%>"/></td><%
                                        %><td><input type="text" name="name" value="<% out.print(employees.get(i).getName());%>"/></td><%
                                        %><td><input type="text" name="fatherName" value="<% out.print(employees.get(i).getFatherName());%>"/></td><%
                                        %><td><input type="date" name="dataOfBirthday" value="<% out.print(employees.get(i).getDataOfBirthday());%>"/></td><%
                                        %><td>
                                            <select name="departmentId">
                                                <option value="<% out.print(employees.get(i).getDep_id());%>">
                                                    <%out.print(employees.get(i).getDepartmentName());%></option>
                                                <%
                                                    for(Department d: departments){
                                                        if(d.getId() != employees.get(i).getDep_id()){
                                                            %><option value="<%out.print(d.getId());%>"><% out.print(d.getDepartmmentName());%></option><%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </td><%
                                        %><td><a class="btn btn-outline-dark" href="?editEmployeeId=0">Cancel</a></td><%
                                        %><td><input class="btn btn-outline-success" type="submit" value="Save"></td><%
                                    %></form></tr><%
                                } else {
                                    %><tr><%
                                        %><td><% out.print(employees.get(i).getId());%></td><%
                                        %><td><% out.print(employees.get(i).getSurname());%></td><%
                                        %><td><% out.print(employees.get(i).getName());%></td><%
                                        %><td><% out.print(employees.get(i).getFatherName());%></td><%
                                        %><td><% out.print(employees.get(i).getDataOfBirthday());%></td><%
                                        %><td><% out.print(employees.get(i).getDepartmentName());%></td><%
                                        %><td><form action="editDeleteEmployee" method="get">
                                            <input type="hidden" name="id" value="<% out.print(employees.get(i).getId());%>"/>
                                            <input class="btn btn-outline-danger" type="submit" value="Delete"/>
                                        </form></td><%
                                        %><td><a class="btn btn-outline-warning" href="?editEmployeeId=<% out.print(employees.get(i).getId()); %>&currentPageEmp=<% out.print(currentPageEmp); %>&currentPageDep=<% out.print(currentPageDep - 1); %>">Edit</a></td><%
                                    %></tr><%
                                    }
                                }
                                editEmployeeId = 0;
                            %></tbody><%
                        %>
                    </table>
                    <a style="float: left;" class="page-link" href="/EmployeeProject/readAddEmployee?currentPageEmp=<% out.print(currentPageEmp - 1); %>&currentPageDep=<% out.print(currentPageDep); %>"><-</a>
                    <div style="float: left;"  class="page-link"><% out.print(currentPageEmp); %> / <% out.print(maxPagesEmp); %></div>
                    <a style="float: left;" class="page-link" href="/EmployeeProject/readAddEmployee?currentPageEmp=<% out.print(currentPageEmp + 1); %>&currentPageDep=<% out.print(currentPageDep); %>">-></a>
                </div>
            </div>
        </div>   

    </body>
</html>
