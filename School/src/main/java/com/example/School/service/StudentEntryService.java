/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.service;

import com.example.School.model.StudentEntry;

/**
 *
 * @author myatko
 */
public interface StudentEntryService {

    StudentEntry save(StudentEntry studentEntry);

    Iterable<StudentEntry> getByClass(String studentClass);
}
