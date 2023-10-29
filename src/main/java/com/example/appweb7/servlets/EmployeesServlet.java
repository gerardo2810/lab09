package com.example.appweb7.servlets;

import com.example.appweb7.beans.Employees;
import com.example.appweb7.daos.EmployeesDaos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeesServlet", value = "/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        EmployeesDaos employeesDaos = new EmployeesDaos();
        ArrayList<Employees> listaEmployees = employeesDaos.listar();

        String vista = "Employees/lista1.jsp";
        request.setAttribute("lista1", listaEmployees);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);

        /*request.setAttribute("lista", listaDonaciones);
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request,response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
