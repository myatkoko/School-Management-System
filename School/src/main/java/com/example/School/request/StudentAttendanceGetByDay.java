/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.request;

import java.math.BigInteger;

/**
 *
 * @author myatko
 */
public class StudentAttendanceGetByDay {

    private BigInteger id;
    private String student_name;
    private String student_class;
    private String student_status;
    private String student_reason;
    private String student_day;
    private String student_month;
    private BigInteger count;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_status() {
        return student_status;
    }

    public void setStudent_status(String student_status) {
        this.student_status = student_status;
    }

    public String getStudent_reason() {
        return student_reason;
    }

    public void setStudent_reason(String student_reason) {
        this.student_reason = student_reason;
    }

    public String getStudent_day() {
        return student_day;
    }

    public void setStudent_day(String student_day) {
        this.student_day = student_day;
    }

    public String getStudent_month() {
        return student_month;
    }

    public void setStudent_month(String student_month) {
        this.student_month = student_month;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
    
    
}
