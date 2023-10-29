package com.example.appweb7.servlets;

import com.example.appweb7.beans.Employees;
import com.example.appweb7.beans.Titles;
import com.example.appweb7.daos.EmployeesDaos;
import com.example.appweb7.daos.TitlesDaos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "TitlesServlet", value = "/TitlesServlet")
public class TitlesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        TitlesDaos titleDao = new TitlesDaos();

                ArrayList<Titles> list = titleDao.listar();

                request.setAttribute("lista",list);
                RequestDispatcher rd = request.getRequestDispatcher("titles/lista.jsp");
                rd.forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        TitlesDaos titlesDaos = new TitlesDaos();

        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        switch (action){
            case "crear"://voy a crear un nuevo trabajo
                String empNo = request.getParameter("empNo");
                String title = request.getParameter("title");
                String fromDate = request.getParameter("fromDate");
                String toDate = request.getParameter("toDate");

                boolean isAllValid = true;

                if(title.length() > 50){
                    isAllValid = false;
                }


                if(isAllValid){

                    Titles titles = titlesDaos.buscarPorId(jobId);

                    if(titles == null){
                        titlesDaos.crear(empNo,title,fromDate,toDate);
                        response.sendRedirect(request.getContextPath() + "/TitleServlet");
                    }else{
                        request.getRequestDispatcher("title/form_new.jsp").forward(request,response);
                    }
                }else{
                    request.getRequestDispatcher("title/form_new.jsp").forward(request,response);
                }
                break;
            case "e": //voy a actualizar
                String empNo1 = request.getParameter("empNo");
                String title1 = request.getParameter("title");
                String fromDate1 = request.getParameter("fromDate");
                String toDate1 = request.getParameter("toDate");

                boolean isAllValid2 = true;

                if(title1.length() > 50){
                    isAllValid2 = false;
                }

                if(isAllValid2){
                    Titles titles = new Titles();
                    titles.setEmpNo(Integer.parseInt(empNo1));
                    titles.setTitle(title1);
                    titles.setFromDate((fromDate1));
                    titles.setToDate((toDate1));

                    titlesDaos.actualizar(titles);
                    response.sendRedirect(request.getContextPath() + "/TitlesServlet");
                }
                break;
            case "s":
                String textBuscar = request.getParameter("textoBuscar");
                ArrayList<Titles> lista = titlesDaos.buscarIdOrTitle(textBuscar);

                request.setAttribute("lista",lista);
                request.setAttribute("busqueda",textBuscar);
                request.getRequestDispatcher("job/lista.jsp").forward(request,response);
                break;
        }
    }
    }
}
