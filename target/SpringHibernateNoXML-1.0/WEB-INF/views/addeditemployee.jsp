<%-- 
    Document   : addeditemployee
    Created on : 10 Ιουλ 2019, 10:28:35 πμ
    Author     : samsung np350
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>   
        <script type="text/javascript">
             $(document).ready(function() {
                $('#myTable').DataTable();
            });
        </script>
    </head>
    <body>
        <h1>${title} Student</h1>
        <form:form method="POST" modelAttribute="employee" action="/SpringHibernateNoXML/employee${what}">
            <table border="1" id="myTable">
                <tr><td>Name</td><td>Joining Date</td><td>Salary</td><td>SSN</td></tr>
                <tr><td><form:input path="name"/></td><td><form:input type="date" path="joiningDate"/></td><td><form:input path="salary"/></td><td><form:input path="ssn"/></td></tr>
            </table>
                <form:input type="hidden" path="id"/>
            <input type="submit" value="${title} employee"/>
        </form:form>
    </body>
</html>
