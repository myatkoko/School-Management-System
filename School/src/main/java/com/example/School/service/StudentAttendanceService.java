/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.service;

import com.example.School.model.StudentAttendance;
import com.example.School.request.StudentAttendanceGetByDay;
import java.util.List;
import java.util.Map;

/**
 *
 * @author myatko
 */
public interface StudentAttendanceService {

    StudentAttendance save(StudentAttendance attendance);

    Iterable<StudentAttendance> getAttendanceByDay(String studentClass, String studentDay, String studentMonth);

    List<Map<String, Object>> getListByClass(String studentClass);

    String getTotalSchoolDay(String studentClass, String studentMonth);

    List<Map<String, Object>> getPresentSchoolDay(String studentClass, String studentMonth);
    
    Iterable<StudentAttendance> getAttendanceByStudent(String studentName, String studentMonth);       
}
