package com.company.teacher.services;

import com.company.teacher.models.Teacher;

import java.util.List;

public interface iService {
    void create(String fullName, String subject, int age, int salary, Long faculty_id);
    Teacher read(Long id);
    void update(Long id, String fullName, String subject, int age, int salary, Long faculty_id);
    void delete(Long id);
    List<Teacher> getAll();
}
