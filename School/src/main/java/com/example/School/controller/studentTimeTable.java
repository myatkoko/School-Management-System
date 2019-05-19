/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.controller;

import com.example.School.model.StudentTimeTable;
import com.example.School.service.StudentTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Admin/TimeTable")
public class studentTimeTable {

    @Autowired
    private StudentTimeTableService timeTableService;

    @GetMapping("")
    public ModelAndView getTimeTable() {
        ModelAndView modelAndView = new ModelAndView("studentTimeTable");
        return modelAndView;
    }

    @PostMapping("/submit_timetable")
    @ResponseBody
    public String getTimeTableAttandacne(@RequestBody Iterable<StudentTimeTable> listStudentTimeTable) {
        for (StudentTimeTable studeTimeTable : listStudentTimeTable) {
            timeTableService.save(studeTimeTable);
        }
        return "Success";
    }

    @GetMapping("/api/getTimeTable")
    @ResponseBody
    public Iterable<StudentTimeTable> getByClass(@RequestParam(value = "class", required = false) String studentClass) {
        Iterable<StudentTimeTable> timetables = timeTableService.getTimeTableByClass(studentClass);
        return timetables;
    }
}
