package com.example.appweb7.daos;

import com.example.appweb7.beans.Employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
public class EmployeesDaos {
    public ArrayList<Employees> listar(){
        ArrayList<Employees> listaEmpleados = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String pass = "root";
        String sql = "select * from employees";

        try(Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();){

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Employees employees = new Employees();
                employees.setEmpNo(rs.getInt(1));
                employees.setBirthDate(rs.getDate(2));
                employees.setFirstName(rs.getString(3));
                employees.setLastName(rs.getString(4));
                employees.setGender(rs.getString(5));
                employees.setHireDate(rs.getDate(6));
                listaEmpleados.add(employees);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaEmpleados;
    }
}
