package com.company.teacher.services;

import com.company.teacher.models.Teacher;
import com.company.teacher.repositories.FacultyRepository;
import com.company.teacher.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService implements iService {
    private final TeacherRepository teacherRepository;
    private final FacultyRepository facultyRepository;

    @Override
    public void create(String fullName, String subject, int age, int salary, Long faculty_id) {
        teacherRepository.save(new Teacher(fullName, subject, age, salary, facultyRepository.findById(faculty_id).get()));
    }

    @Override
    public Teacher read(Long id) {
        if (teacherRepository.findById(id).isPresent()) {
            return teacherRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void update(Long id, String fullName, String subject, int age, int salary, Long faculty_id) {
        if (teacherRepository.findById(id).isPresent() && facultyRepository.findById(faculty_id).isPresent()) {
            teacherRepository.save(teacherRepository.findById(id).get()
                    .setFullName(fullName)
                    .setSubject(subject)
                    .setAge(age)
                    .setSalary(salary)
                    .setFaculty(facultyRepository.findById(faculty_id).get())
            );
        }
    }

    @Override
    public void delete(Long id) {
        if (teacherRepository.findById(id).isPresent()) {
            teacherRepository.delete(teacherRepository.findById(id).get());
        }
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }
}
