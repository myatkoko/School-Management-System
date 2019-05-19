/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.dao;

import com.example.School.model.StudentAttendance;
import com.example.School.request.StudentAttendanceGetByDay;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author myatko
 */
@Repository
public interface StudentAttendanceDao extends CrudRepository<StudentAttendance, Long> {

    StudentAttendance save(StudentAttendance attendance);

    @Query(value = "select SE.student_id, SE.student_name_eng from student_entry SE where SE.student_future_class = :studentClass", nativeQuery = true)
    List<Map<String, Object>> getListByClass(@Param("studentClass") String studentClass);

    @Query(value = "select * from student_attendance SA where SA.student_class = :studentClass and SA.student_day = :studentDay and SA.student_month = :studentMonth", nativeQuery = true)
    Iterable<StudentAttendance> getAttendanceByDay(@Param("studentClass") String studentClass, @Param("studentDay") String studentDay, @Param("studentMonth") String studentMonth);

    @Query(value = "select count(SA.id) as count from student_attendance SA where SA.student_class = :studentClass and SA.student_month = :studentMonth group by SA.student_name", nativeQuery = true)
    String getTotalSchoolDay(@Param("studentClass") String studentClass, @Param("studentMonth") String studentMonth);

    @Query(value = "select count(SA.id) as count, SA.* from student_attendance SA where SA.student_class = :studentClass and SA.student_month = :studentMonth and SA.student_status = 'Present' group by SA.student_name", nativeQuery = true)
    List<Map<String, Object>> getPresentSchoolDay(@Param("studentClass") String studentClass, @Param("studentMonth") String studentMonth);

    @Query(value = "select * from student_attendance SA where SA.student_name = :studentName and SA.student_month = :studentMonth", nativeQuery = true)
    Iterable<StudentAttendance> getAttendanceByStudent(@Param("studentName") String studentName, @Param("studentMonth") String studentMonth);
}
