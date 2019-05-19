/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author myatko
 */
@Entity
@Table(name = "studentEntry")
public class StudentEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String studentNameMM;
    private String studentNameEng;
    private String studentNRC;
    private String studentBirthday;
    private String studentFatherName;
    private String studentMotherName;
    private String studentReligious;
    private String studentPassedSchool;
    private String studentPassedClass;
    private String studentFutureClass;
    private String studentSubject;
    private String studentAddress;
    private String studentPhone;
    private String studentEntryDate;
    private String studentProfile;
    private String fatherId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNameMM() {
        return studentNameMM;
    }

    public void setStudentNameMM(String studentNameMM) {
        this.studentNameMM = studentNameMM;
    }

    public String getStudentNameEng() {
        return studentNameEng;
    }

    public void setStudentNameEng(String studentNameEng) {
        this.studentNameEng = studentNameEng;
    }

    public String getStudentNRC() {
        return studentNRC;
    }

    public void setStudentNRC(String studentNRC) {
        this.studentNRC = studentNRC;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(String studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentFatherName() {
        return studentFatherName;
    }

    public void setStudentFatherName(String studentFatherName) {
        this.studentFatherName = studentFatherName;
    }

    public String getStudentMotherName() {
        return studentMotherName;
    }

    public void setStudentMotherName(String studentMotherName) {
        this.studentMotherName = studentMotherName;
    }

    public String getStudentReligious() {
        return studentReligious;
    }

    public void setStudentReligious(String studentReligious) {
        this.studentReligious = studentReligious;
    }

    public String getStudentPassedSchool() {
        return studentPassedSchool;
    }

    public void setStudentPassedSchool(String studentPassedSchool) {
        this.studentPassedSchool = studentPassedSchool;
    }

    public String getStudentPassedClass() {
        return studentPassedClass;
    }

    public void setStudentPassedClass(String studentPassedClass) {
        this.studentPassedClass = studentPassedClass;
    }

    public String getStudentFutureClass() {
        return studentFutureClass;
    }

    public void setStudentFutureClass(String studentFutureClass) {
        this.studentFutureClass = studentFutureClass;
    }

    public String getStudentSubject() {
        return studentSubject;
    }

    public void setStudentSubject(String studentSubject) {
        this.studentSubject = studentSubject;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEntryDate() {
        return studentEntryDate;
    }

    public void setStudentEntryDate(String studentEntryDate) {
        this.studentEntryDate = studentEntryDate;
    }

    public String getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(String studentProfile) {
        this.studentProfile = studentProfile;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

}
