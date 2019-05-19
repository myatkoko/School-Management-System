/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.service.impl;

import com.example.School.dao.StudentAttendanceDao;
import com.example.School.model.StudentAttendance;
import com.example.School.service.StudentAttendanceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author myatko
 */
@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    @Autowired
    StudentAttendanceDao studentAttendanceDao;

    @Override
    public StudentAttendance save(StudentAttendance attendance) {
        return studentAttendanceDao.save(attendance);
    }

    @Override
    public Iterable<StudentAttendance> getAttendanceByDay(String studentClass, String studentDay, String studentMonth) {
        return studentAttendanceDao.getAttendanceByDay(studentClass, studentDay, studentMonth);
    }

    @Override
    public List<Map<String, Object>> getListByClass(String studentClass) {
        return studentAttendanceDao.getListByClass(studentClass);
    }

    @Override
    public String getTotalSchoolDay(String studentClass, String studentMonth) {
        return studentAttendanceDao.getTotalSchoolDay(studentClass, studentMonth);
    }

    @Override
    public List<Map<String, Object>> getPresentSchoolDay(String studentClass, String studentMonth) {
        return studentAttendanceDao.getPresentSchoolDay(studentClass, studentMonth);
    }

    @Override
    public Iterable<StudentAttendance> getAttendanceByStudent(String studentName, String studentMonth) {
        return studentAttendanceDao.getAttendanceByStudent(studentName, studentMonth);
    }
}
