/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.service.impl;

import com.example.School.dao.StudentTimeTableDao;
import com.example.School.model.StudentTimeTable;
import com.example.School.service.StudentTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author myatko
 */
@Service
public class StudentTimeTableServiceImpl implements StudentTimeTableService {

    @Autowired
    StudentTimeTableDao timeTableDao;

    public StudentTimeTable save(StudentTimeTable timetable) {
        return timeTableDao.save(timetable);
    }

    @Override
    public Iterable<StudentTimeTable> getTimeTableByClass(String studentClass) {
        return timeTableDao.getTimeTableByClass(studentClass);
    }
}
