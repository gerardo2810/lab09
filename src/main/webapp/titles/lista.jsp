<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.appweb7.beans.Titles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Titles> lista = (ArrayList<Titles>) request.getAttribute("lista"); %>
<html>
    <head>
        <title>Title</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <h1> Titles </h1>
        <table class="table tablr striped mt-3">
            <tr class="table-secondary">
                <th> Emp No </th>
                <th> Title</th>
                <th> From Date</th>
                <th> To Date </th>
            </tr>
            <%for (Titles titles: lista) {%>
            <tr>
                <td> <%= titles.getEmpNo() %></td>
                <td> <%= titles.getTitle() %></td>
                <td> <%= titles.getFromDate() %></td>
                <td> <%= titles.getToDate() %></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
