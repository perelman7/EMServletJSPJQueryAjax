<%@page import="com.mycompany.employeeproject.model.Department"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous"/>
    </head>
    <body>
        <%
            List<Department> departments = (List<Department>) session.getAttribute("modelDepartments");
        %>
        <div class="container">
            <form action="editDeleteEmployee" method="post">
                <div class="form-group">
                    <label for="surname">Surname</label>
                    <input class="form-control" type="text" name="surname" placeholder="Enter surname"/>
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input class="form-control" type="text" name="name" placeholder="Enter name"/>
                </div>
                <div class="form-group">
                    <label for="fatherName">Name of father</label>
                    <input class="form-control" type="text" name="fatherName" placeholder="Enter name of father"/>
                </div>
                <div class="form-group">
                    <label for="dataOfBirthday">Date of birth</label>
                    <input class="form-control" type="date" name="dataOfBirthday"/>
                </div>
                <div class="form-group">
                    <label for="departmentId">Department</label>
                    <select class="form-control" name="departmentId">
                        <%
                            for (Department d : departments) {
                        %><option value="<%= d.getId()%>"><%= d.getDepartmmentName()%></option><%
                                    }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <a class="btn btn-outline-dark" href="/EmployeeProject/readAddEmployee">Cancel</a>
                    <td><input class="btn btn-outline-success" type="submit" value="Add">
                </div>
            </form>
        </div>
    </body>
</html>
