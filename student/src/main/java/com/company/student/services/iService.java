package com.company.student.services;

import com.company.student.models.Student;

import java.util.List;

public interface iService {
    void create(String fullName, int age, int course, String group);
    Student read(Long id);
    void update(Long id, String fullName, int age, int course, String group);
    void delete(Long id);
    List<Student> getAll();
}
