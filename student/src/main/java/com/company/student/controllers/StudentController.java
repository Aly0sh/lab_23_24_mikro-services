package com.company.student.controllers;

import com.company.student.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/")
    public String allStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "student";
    }

    @GetMapping("/create")
    public String createPage() {
        return "create";
    }

    @PostMapping("/create")
    public RedirectView create(
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int course,
            @RequestParam String group
    ) {
        studentService.create(fullName, age, course, group);
        return new RedirectView("http://localhost:8090/student/");
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new RedirectView("http://localhost:8090/student/");
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", studentService.read(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public RedirectView update(
            @PathVariable("id") Long id,
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int course,
            @RequestParam String group
    ) {
        studentService.update(id, fullName, age, course, group);
        return new RedirectView("http://localhost:8090/student/");
    }
}
