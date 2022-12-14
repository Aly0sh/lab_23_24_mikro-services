package com.company.student.controllers;

import com.company.student.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
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
    public String create(
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int course,
            @RequestParam String group
    ) {
        studentService.create(fullName, age, course, group);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", studentService.read(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") Long id,
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int course,
            @RequestParam String group
    ) {
        studentService.update(id, fullName, age, course, group);
        return "redirect:/";
    }
}
