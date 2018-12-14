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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.min.css" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                        <a class="nav-link" href="/EmployeeProject/index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <div>
                    <a class="btn btn-light" href="googleLogout">Log out</a>
                </div>
            </div>
        </nav>
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <h1>Login page!</h1>
            </div>
            <div class="row h-100 justify-content-center align-items-center">
                <form action="googleLogin" method="GET" > 
                    <button class="btn btn-block btn-social btn-google" type="submit"><i class="fa fa-google"></i> Sign in with Google</button> 
                </form>
            </div>
        </div>
    </body>
</html>
