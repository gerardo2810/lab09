package com.example.appweb7.beans;

import java.util.Date;

public class Titles {
    private int empNo;
    private String title;
    private Date fromDate;
    private Date toDate;


    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.sql.Date getFromDate() {

        return new java.sql.Date(fromDate.getTime());
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public java.sql.Date getToDate() {

        return new java.sql.Date(toDate.getTime());
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
