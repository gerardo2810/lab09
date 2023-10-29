<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.appweb7.beans.Employees" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Employees> lista = (ArrayList<Employees>) request.getAttribute("lista1"); %>
<html>
    <head>
    <title>Title</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <h1> Lista de empleados</h1>
        <table class="table tablr striped mt-3">
            <tr class="table-secondary">
                <th>Emp No</th>>
                <th> Birth_Date</th>
                <th> First Name</th>
                <th> Last Name </th>
                <th> Gender </th>
                <th>  Hire Date  </th>>
            </tr>
            <% for (Employees employees: lista) {%>
            <tr>
                <td><%= employees.getEmpNo() %></td>
                <td> <%= employees.getBirthDate() %></td>
                <td> <%= employees.getFirstName() %></td>
                <td> <%= employees.getLastName()%></td>
                <td> <%= employees.getGender() %></td>
                <td> <%= employees.getHireDate()%></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
