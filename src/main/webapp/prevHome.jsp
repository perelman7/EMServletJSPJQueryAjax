<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous"/>
    </head>
    <body>
        <c:choose>
            <c:when test="${param.currentPageEmp == null}">
                <c:set var="currentPageEmp" value="1"></c:set>
            </c:when>
            <c:when test="${param.currentPageEmp <= 1}">
                <c:set var="currentPageEmp" value="1"></c:set>
            </c:when>
            <c:when test="${param.currentPageEmp >= param.maxPagesEmp}">
                <c:set var="currentPageEmp" value="${param.maxPagesEmp}"></c:set>
            </c:when>
            <c:otherwise>
                <c:set var="currentPageEmp" value="${param.currentPageEmp}"></c:set>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${param.maxPagesEmp == null}">
                <c:set var="maxPagesEmp" value="${list.empDeps.size() / 10}"></c:set>
                <fmt:formatNumber var = "maxPagesEmp" maxFractionDigits="0" value="${maxPagesEmp + (maxPagesEmp % 1 == 0 ? 0 : 0.5)}" />
            </c:when>
            <c:otherwise>
                <c:set var="maxPagesEmp" value="${param.maxPagesEmp}"></c:set>
            </c:otherwise>
        </c:choose>
        
        <!-- pagination for department -->
        <c:choose>
            <c:when test="${param.currentPageDep == null}">
                <c:set var="currentPageDep" value="1"></c:set>
            </c:when>
            <c:when test="${param.currentPageDep <= 1}">
                <c:set var="currentPageDep" value="1"></c:set>
            </c:when>
            <c:when test="${param.currentPageDep >= param.maxPagesDep}">
                <c:set var="currentPageDep" value="${param.maxPagesDep}"></c:set>
            </c:when>
            <c:otherwise>
                <c:set var="currentPageDep" value="${param.currentPageDep}"></c:set>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${param.maxPagesDep == null}">
                <c:set var="maxPagesDep" value="${list.departments.size() / 10}"></c:set>
                <fmt:formatNumber var = "maxPagesDep" maxFractionDigits="0" value="${maxPagesDep + (maxPagesDep % 1 == 0 ? 0 : 0.5)}" />
            </c:when>
            <c:otherwise>
                <c:set var="maxPagesDep" value="${param.maxPagesDep}"></c:set>
            </c:otherwise>
        </c:choose>
        
        <div class="container-fluid">
            <div class="row">
                <h1>Home JSP!</h1>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <table class="table table-bordered table-sm table-hover">
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Surname</td>
                                <td>Name</td>
                                <td>Father name</td>
                                <td>Date of birth</td>
                                <td>Department</td>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${list.empDeps}" var = "emp" begin="${10*(currentPageEmp - 1)}" end="${(10 + 10*(currentPageEmp - 1) - 1 )}">
                                <tr>
                                    <td>${emp.id}</td>
                                    <td>${emp.surname}</td>
                                    <td>${emp.name}</td>
                                    <td>${emp.fatherName}</td>
                                    <td>${emp.dataOfBirthday}</td>
                                    <td>${emp.departmentName}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a style="float: left;" class="page-link" href="?currentPageEmp=${currentPageEmp - 1}&maxPagesEmp=${maxPagesEmp}&currentPageDep=${currentPageDep}&maxPagesDep=${maxPagesDep}"><-</a>
                    <div style="float: left;"  class="page-link">${currentPageEmp} / ${maxPagesEmp}</div>
                    <a style="float: left;" class="page-link"  href="?currentPageEmp=${currentPageEmp + 1}&maxPagesEmp=${maxPagesEmp}&currentPageDep=${currentPageDep}&maxPagesDep=${maxPagesDep}">-></a>
                </div>
                <div class="col-lg-6">
                    <table class="table table-bordered table-sm table-hover">
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Name</td>
                                <td>Description</td>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${list.departments}" var = "deps" begin="${10*(currentPageDep - 1)}" end="${(10 + 10*(currentPageDep - 1) - 1 )}">
                                <tr>
                                    <td>${deps.id}</td>
                                    <td>${deps.departmmentName}</td>
                                    <td>${deps.description}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a style="float: left;" class="page-link" href="?currentPageEmp=${currentPageEmp}&maxPagesEmp=${maxPagesEmp}&currentPageDep=${currentPageDep - 1}&maxPagesDep=${maxPagesDep}"><-</a>
                    <div style="float: left;"  class="page-link">${currentPageDep} / ${maxPagesDep}</div>
                    <a style="float: left;" class="page-link"  href="?currentPageEmp=${currentPageEmp}&maxPagesEmp=${maxPagesEmp}&currentPageDep=${currentPageDep + 1}&maxPagesDep=${maxPagesDep}">-></a>
                </div>
            </div>
        </div>
    </body>
</html>