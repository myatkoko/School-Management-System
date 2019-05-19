/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.dao;

import com.example.School.model.StudentEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myatko
 */
@Repository
public interface StudentEntryDao extends CrudRepository<StudentEntry, Long> {

    StudentEntry save(StudentEntry studentEntry);
    
    @Query(value = "select * from student_entry SE where SE.student_future_class = :studentClass", nativeQuery = true)
    Iterable<StudentEntry> getByClass(@Param("studentClass") String studentClass);
}
