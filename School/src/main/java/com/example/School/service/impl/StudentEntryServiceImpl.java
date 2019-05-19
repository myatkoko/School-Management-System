/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.service.impl;

import com.example.School.dao.StudentEntryDao;
import com.example.School.model.StudentEntry;
import com.example.School.service.StudentEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author myatko
 */
@Service
public class StudentEntryServiceImpl implements StudentEntryService {

    @Autowired
    StudentEntryDao studentEntryDao;

    public StudentEntry save(StudentEntry studentEntry) {
        return studentEntryDao.save(studentEntry);
    }

    @Override
    public Iterable<StudentEntry> getByClass(String studentClass) {
        return studentEntryDao.getByClass(studentClass);
    }

}
