package com.company.faculty.controllers;

import com.company.faculty.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;


    @GetMapping("/")
    public String allStudents(Model model) {
        model.addAttribute("faculties", facultyService.getAll());
        return "faculty";
    }

    @GetMapping("/create")
    public String createPage() {
        return "create";
    }

    @PostMapping("/create")
    public RedirectView create(
            @RequestParam String name,
            @RequestParam int price
    ) {
        facultyService.create(name, price);
        return new RedirectView("http://localhost:8090/faculty/");
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id) {
        facultyService.delete(id);
        return new RedirectView("http://localhost:8090/faculty/");
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("faculty", facultyService.read(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public RedirectView update(
            @PathVariable("id") Long id,
            @RequestParam String name,
            @RequestParam int price
    ) {
        facultyService.update(id, name, price);
        return new RedirectView("http://localhost:8090/faculty/");
    }
}
