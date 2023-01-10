package com.company.student.controllers;

import com.company.student.repositories.FacultyRepository;
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
    private final FacultyRepository facultyRepository;

    @GetMapping("/")
    public String allStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "student";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("faculties", facultyRepository.findAll());
        return "create";
    }

    @PostMapping("/create")
    public RedirectView create(
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int course,
            @RequestParam String group,
            @RequestParam Long faculty_id
    ) {
        studentService.create(fullName, age, course, group, faculty_id);
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
        model.addAttribute("faculties", facultyRepository.findAll());
        return "update";
    }

    @PostMapping("/update/{id}")
    public RedirectView update(
            @PathVariable("id") Long id,
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int course,
            @RequestParam String group,
            @RequestParam Long faculty_id
    ) {
        studentService.update(id, fullName, age, course, group, faculty_id);
        return new RedirectView("http://localhost:8090/student/");
    }
}
