<%-- 
    Document   : test
    Created on : Jul 9, 2019, 8:50:12 PM
    Author     : George.Pasparakis
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test View</title>
    </head>
    <body>
        <table>
            <tr><td>Name</td><td>Joining Date</td><td>Salary</td><td>SSN</td><td>Update</td><td>Delete</td></tr>
            <c:forEach var="e" items="${employees}">
                <tr><td>${e.name}</td><td>${e.joiningDate}</td><td>${e.salary}</td><td>${e.ssn}</td><td><a href="/SpringHibernateNoXML/employeeupdate/${e.id}">Edit</a></td><td><a href="/SpringHibernateNoXML/employeedelete/${e.ssn}">Delete</a></td></tr>
            </c:forEach>
        </table>
        <p>${message}</p><br>
        <p><a href="/SpringHibernateNoXML/addemployee">Add new Employee</a></p>
        <p><a href="/SpringHibernateNoXML/">Home Page</a>
    </body>
</html>
