package com.company.teacher.controllers;

import com.company.teacher.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/")
    public String allTeachers(Model model) {
        model.addAttribute("teachers", teacherService.getAll());
        return "teacher";
    }

    @GetMapping("/create")
    public String createPage() {
        return "create";
    }

    @PostMapping("/create")
    public RedirectView create(
            @RequestParam String fullName,
            @RequestParam int salary,
            @RequestParam int age,
            @RequestParam String subject
    ) {
        teacherService.create(fullName, subject, age, salary);
        return new RedirectView("http://localhost:8090/teacher/");
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id) {
        teacherService.delete(id);
        return new RedirectView("http://localhost:8090/teacher/");
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("teacher", teacherService.read(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public RedirectView update(
            @PathVariable("id") Long id,
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int salary,
            @RequestParam String subject
    ) {
        teacherService.update(id, fullName, subject, age, salary);
        return new RedirectView("http://localhost:8090/teacher/");
    }
}
