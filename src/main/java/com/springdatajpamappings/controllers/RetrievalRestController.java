package com.springdatajpamappings.controllers;

import com.springdatajpamappings.dtos.TeacherWithLaptop;
import com.springdatajpamappings.services.RetrievalRestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RetrievalRestController {

    @Autowired
    private RetrievalRestServices retrievalRestServices;

    @PostMapping("/retrieve/teacherLaptop/{id}")
    public ResponseEntity<TeacherWithLaptop> saveStudentWithLaptop(@PathVariable Integer id) {
        return retrievalRestServices.getTeacherLaptop(id);
    }
}
