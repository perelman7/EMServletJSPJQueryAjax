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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">EMPLOYEE PROJECT</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar1" aria-controls="navbar1" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbar1">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/EmployeeProject/readAddEmployee">JSP Tables <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/EmployeeProject/index.html">Home <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <div>
                    <a class="btn btn-light" href="googleLogout">Log out</a>
                </div>
                <div>
                    <a class="btn btn-light" href="login.jsp">Log in</a>
                </div>
            </div>
        </nav>
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <h1>Form for adding employee</h1>
                <form action="/EmployeeProject/readAddEmployee" method="POST" class="col-12">
                    <div class="form-group">
                        <label for="surname">Surname</label>
                        <input class="form-control" type="text" name="surname" required placeholder="Enter surname"/>
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input class="form-control" type="text" name="name" required placeholder="Enter name"/>
                    </div>
                    <div class="form-group">
                        <label for="fatherName">Name of father</label>
                        <input class="form-control" type="text" name="fatherName" placeholder="Enter name of father"/>
                    </div>
                    <div class="form-group">
                        <label for="dataOfBirthday">Date of birth</label>
                        <input class="form-control" type="date" required name="dataOfBirthday"/>
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
                        <input class="btn btn-outline-success" type="submit" value="Add">
                    </div>
                </form>   
            </div>  
        </div>
    </body>
</html>
