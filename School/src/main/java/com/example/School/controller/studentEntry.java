/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.controller;

import com.example.School.model.StudentEntry;
import com.example.School.request.StudentEntryRequest;
import com.example.School.service.StudentEntryService;
import com.example.School.util.MyanmarFontManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author myatko
 */
@Controller
@RequestMapping("/Admin/StudentEntry")
public class studentEntry {

    @Autowired
    ServletContext context;

    private String PATH = "D://Spring Image/";

    @Autowired
    private StudentEntryService studentEntryService;

    @GetMapping("")
    public ModelAndView getMainPage(Model model, @RequestParam(value = "class", required = false) String studentClass) {
        Iterable<StudentEntry> studentList = studentEntryService.getByClass(studentClass);
        for (StudentEntry student : studentList) {
            student.setStudentNameMM(MyanmarFontManager.unicodeToZawgyi(student.getStudentNameMM()));
            student.setStudentNRC(MyanmarFontManager.unicodeToZawgyi(student.getStudentNRC()));
            student.setStudentFatherName(MyanmarFontManager.unicodeToZawgyi(student.getStudentFatherName()));
            student.setStudentMotherName(MyanmarFontManager.unicodeToZawgyi(student.getStudentMotherName()));
            student.setStudentReligious(MyanmarFontManager.unicodeToZawgyi(student.getStudentReligious()));
            student.setStudentPassedSchool(MyanmarFontManager.unicodeToZawgyi(student.getStudentPassedSchool()));
            student.setStudentAddress(MyanmarFontManager.unicodeToZawgyi(student.getStudentAddress()));
        }
        model.addAttribute("studentClass", studentClass);
        model.addAttribute("studentList", studentList);
        ModelAndView modelAndView = new ModelAndView("studentEntry");
        modelAndView.addObject(model);
        return modelAndView;
    }

    @Secured("ADMIN")
    @PostMapping("/")
    @ResponseBody
    public String saveStudent(@Validated StudentEntryRequest request) throws IOException {
        MultipartFile file = request.getFile();
        FileCopyUtils.copy(file.getBytes(), new File(PATH + file.getOriginalFilename()));
        StudentEntry studentEntry = new StudentEntry();
        studentEntry.setStudentEntryDate(request.getStudentEntryDate());
        studentEntry.setStudentProfile("http://localhost:8080/Admin/StudentEntry/download?file_name=" + file.getOriginalFilename());
        studentEntry.setStudentNameMM(MyanmarFontManager.zawgyiToUnicode(request.getStudentNameMM()));
        studentEntry.setStudentNameEng(request.getStudentNameEng());
        studentEntry.setStudentNRC(MyanmarFontManager.zawgyiToUnicode(request.getStudentNRC()));
        studentEntry.setStudentBirthday(request.getStudentBirthday());
        studentEntry.setStudentFatherName(MyanmarFontManager.zawgyiToUnicode(request.getStudentFatherName()));
        studentEntry.setStudentMotherName(MyanmarFontManager.zawgyiToUnicode(request.getStudentMotherName()));
        studentEntry.setStudentReligious(MyanmarFontManager.zawgyiToUnicode(request.getStudentReligious()));
        studentEntry.setStudentPassedSchool(MyanmarFontManager.zawgyiToUnicode(request.getStudentPassedSchool()));
        studentEntry.setStudentPassedClass(request.getStudentPassedClass());
        studentEntry.setStudentFutureClass(request.getStudentFutureClass());
        studentEntry.setStudentSubject(request.getStudentSubject());
        studentEntry.setStudentAddress(MyanmarFontManager.zawgyiToUnicode(request.getStudentAddress()));
        studentEntry.setStudentPhone(request.getStudentPhone());
        studentEntry.setFatherId(request.getFatherId());
        studentEntryService.save(studentEntry);
        return "Success";
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam String file_name) throws IOException {
        File file = new File(PATH + file_name);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG).contentLength(file.length())
                .body(resource);
    }
}
