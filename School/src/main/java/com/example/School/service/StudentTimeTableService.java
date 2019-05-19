/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.service;

import com.example.School.model.StudentTimeTable;

/**
 *
 * @author myatko
 */
public interface StudentTimeTableService {
     StudentTimeTable save(StudentTimeTable timetable);
     
     Iterable<StudentTimeTable> getTimeTableByClass(String studentClass);
}
