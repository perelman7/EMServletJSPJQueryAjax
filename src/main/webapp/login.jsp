<%-- 
    Document   : login
    Created on : Dec 13, 2018, 10:59:47 AM
    Author     : asaburov
--%>

<%@page import="org.scribe.model.Token"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">EMPLOYEE PROJECT</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar1" aria-controls="navbar1" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbar1">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="readAddEmployee">JSP Tables <span class="sr-only">(current)</span></a>
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
        <h1>Login page!</h1>
        <form action="googleLogin" method="GET" > 
            <button type="submit">Login</button> 
        </form>
        <%
            try{
                String name = String.valueOf(session.getAttribute("name")); 
                String email = String.valueOf(session.getAttribute("email"));
                Token token = (Token)session.getAttribute("token");
                
                out.print("Name: " + name); %> <br> <%
                out.print("Email: " + email);%> <br> <%
                out.print("Token token: " + token.getToken());%> <br> <%
                out.print("Token secret: " + token.getSecret());%> <br> <%  
                out.print("Token raw: " + token.getRawResponse());%> <br> <%
                out.print("Token tostr: " + token.toString());%> <br> <%  
                out.print(request.getRemoteUser());%> <br> <%
                    
            }catch(Exception e){}
        %>
    </body>
</html>
