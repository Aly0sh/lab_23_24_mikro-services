package com.company.student.controllers;

import com.company.student.services.iService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private iService studentService;


}
