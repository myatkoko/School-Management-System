/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.request;

import com.example.School.model.StudentAttendance;

/**
 *
 * @author myatko
 */
public class StudentAttendanceRequest {
    private Iterable<StudentAttendance> studentAttendance;
    private String studentDay;
    private String studentMonth;

    public Iterable<StudentAttendance> getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(Iterable<StudentAttendance> studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public String getStudentDay() {
        return studentDay;
    }

    public void setStudentDay(String studentDay) {
        this.studentDay = studentDay;
    }

    public String getStudentMonth() {
        return studentMonth;
    }

    public void setStudentMonth(String studentMonth) {
        this.studentMonth = studentMonth;
    }
  
}
