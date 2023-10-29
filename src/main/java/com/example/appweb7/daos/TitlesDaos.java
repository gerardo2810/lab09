package com.example.appweb7.daos;

import com.example.appweb7.beans.Employees;
import com.example.appweb7.beans.Titles;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class TitlesDaos {
    public ArrayList<Titles> listar(){
        ArrayList<Titles> listaTitles = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String pass = "root";
        String sql = "select * from titles";

        try(Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();){

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Titles titles = new Titles();
                titles.setEmpNo(rs.getInt(1));
                titles.setTitle(rs.getString(2));
                titles.setFromDate(rs.getDate(3));
                titles.setToDate(rs.getDate(4));
                listaTitles.add(titles);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaTitles;
    }
    public void crearTitles(int empNo, String title, Date fromDate, Date toDate){
        try {
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/employees";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection conn = DriverManager.getConnection(url, user, pass);){
                String sql = "INSERT INTO jobs (emp_no,title,from_date,to_date) " +
                        "VALUES (?,?,?,?)";
                try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                    pstmt.setInt(1, empNo);
                    pstmt.setString(2, title);
                    pstmt.setDate(3, (java.sql.Date) fromDate);
                    pstmt.setDate(4, (java.sql.Date) toDate);
                    pstmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void borrarTitle(int empNo) {
        try {
            String user = "root";
            String pass = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/employees";

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass);) {
                String sql = "DELETE FROM titles WHERE emp_no = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, empNo);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void actualizar(Titles titles){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/employees";
        String username = "root";
        String password = "root";

        String sql = "update titles set title = ?, from_date = ?, to_date = ? where emp_no = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,titles.getTitle());
            pstmt.setDate(2,titles.getFromDate());
            pstmt.setDate(3,titles.getToDate());
            pstmt.setInt(4,titles.getEmpNo());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
