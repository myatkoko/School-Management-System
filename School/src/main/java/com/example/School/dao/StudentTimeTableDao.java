/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.dao;

import com.example.School.model.StudentTimeTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myatko
 */
@Repository
public interface StudentTimeTableDao extends CrudRepository<StudentTimeTable, Long> {

    StudentTimeTable save(StudentTimeTable timetable);

    @Query(value = "select * from student_time_table STT where STT.student_class = :studentClass", nativeQuery = true)
    Iterable<StudentTimeTable> getTimeTableByClass(@Param("studentClass") String studentClass);

}
