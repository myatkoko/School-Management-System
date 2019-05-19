/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.controller;

import com.example.School.model.StudentAttendance;
import com.example.School.request.StudentAttendanceGetByDay;
import com.example.School.request.StudentAttendanceRequest;
import com.example.School.service.StudentAttendanceService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myatko
 */
@Controller
@RequestMapping("/Admin/StudentAttendance")
public class studentAttendance {

    @Autowired
    ServletContext context;

    @Autowired
    private StudentAttendanceService studentAttendanceService;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @GetMapping("/AddAttendance")
    public ModelAndView getAddAttendance() {
        ModelAndView modelAndView = new ModelAndView("studentAttendance");
        return modelAndView;
    }

    @GetMapping("/GetByDay")
    public ModelAndView getByDay() {
        ModelAndView modelAndView = new ModelAndView("studentAttendanceGetByDay");
        return modelAndView;
    }

    @GetMapping("/GetByMonth")
    public ModelAndView getByMonth(Model model, @RequestParam(value = "class", required = false) String studentClass) {
        ModelAndView modelAndView = new ModelAndView("studentAttendanceGetByMonth");
        return modelAndView;
    }

    @GetMapping("/GetByStudent")
    public ModelAndView getByStudent(Model model, @RequestParam(value = "class", required = false) String studentClass) {
        ModelAndView modelAndView = new ModelAndView("studentAttendanceGetByStudent");
        return modelAndView;
    }

    @GetMapping("/api/getStudentByClass")
    @ResponseBody
    public List<Map<String, Object>> getStudentByClass(@RequestParam(value = "class", required = false) String studentClass) {
        List<Map<String, Object>> attendances = studentAttendanceService.getListByClass(studentClass);
        return attendances;
    }

    @GetMapping("/api/getByDay")
    @ResponseBody
    public Iterable<StudentAttendance> getByDay(@RequestParam(value = "class", required = false) String studentClass, @RequestParam(value = "day", required = false) String studentDay, @RequestParam(value = "month", required = false) String studentMonth) {
        Iterable<StudentAttendance> attendances = studentAttendanceService.getAttendanceByDay(studentClass, studentDay, studentMonth);
        return attendances;
    }

    @GetMapping("/api/getByMonthTotal")
    @ResponseBody
    public Double getByMonthTotal(@RequestParam(value = "class", required = false) String studentClass, @RequestParam(value = "month", required = false) String studentMonth) {
        Double totalSchoolDay = Double.parseDouble(studentAttendanceService.getTotalSchoolDay(studentClass, studentMonth));
        return totalSchoolDay;
    }

    @GetMapping("/api/getByMonthPresent")
    @ResponseBody
    public List<Map<String, Object>> getByMonthPresent(@RequestParam(value = "class", required = false) String studentClass, @RequestParam(value = "month", required = false) String studentMonth) {
        List<Map<String, Object>> totalPresentDay = studentAttendanceService.getPresentSchoolDay(studentClass, studentMonth);
        return totalPresentDay;
    }

    @GetMapping("/api/getbyStudent")
    @ResponseBody
    public Iterable<StudentAttendance> getByStudent(@RequestParam(value = "name", required = false) String studentName, @RequestParam(value = "month", required = false) String studentMonth) {
        Iterable<StudentAttendance> getByStudent = studentAttendanceService.getAttendanceByStudent(studentName, studentMonth);
        return getByStudent;
    }

    @PostMapping("/submit_attendance")
    @ResponseBody
    public String getSubmitAttandacne(@RequestBody StudentAttendanceRequest listStudentAttendance) {
        for (StudentAttendance studentAttendance : listStudentAttendance.getStudentAttendance()) {
            studentAttendance.setStudentDay(listStudentAttendance.getStudentDay());
            studentAttendance.setStudentMonth(listStudentAttendance.getStudentMonth());
            studentAttendanceService.save(studentAttendance);
        }
        return "Success";
    }
}
