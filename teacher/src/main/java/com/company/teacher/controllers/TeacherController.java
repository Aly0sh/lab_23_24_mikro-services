package com.company.teacher.controllers;

import com.company.teacher.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
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
    public String create(
            @RequestParam String fullName,
            @RequestParam int salary,
            @RequestParam int age,
            @RequestParam String subject
    ) {
        teacherService.create(fullName, subject, age, salary);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        teacherService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("teacher", teacherService.read(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") Long id,
            @RequestParam String fullName,
            @RequestParam int age,
            @RequestParam int salary,
            @RequestParam String subject
    ) {
        teacherService.update(id, fullName, subject, age, salary);
        return "redirect:/";
    }
}
