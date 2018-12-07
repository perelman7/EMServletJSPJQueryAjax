<%@page  language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        <script type="text/javascript" src="js/dep_ajax.js"></script>
        <script type="text/javascript" src="js/emp_ajax.js"></script>
        <script type="stylesheet" src="js/style.css"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2">
                    <h1>Hello app!!!</h1>
                </div>
                <div class="col-lg-2"></div>
                <div class="col-lg-8"></div>
            </div>
            <div class="row">
                <div class="col-lg-5">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-11">
                        <div id="resp_ajax_deps"></div>
                        
                    </div>
                </div>
                <div class="col-lg-7">
                    <div id="resp_ajax_emps"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-11">
                        <div id="resp_d"></div>  
                    </div>
                </div>
                <div class="col-lg-6">
                    <div id="resp_e"></div>  
                </div>
            </div>
        </div>
        
    </body>
</html>
