package com.company.teacher.services;

import com.company.teacher.models.Teacher;
import com.company.teacher.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService implements iService {
    private final TeacherRepository teacherRepository;

    @Override
    public void create(String fullName, String subject, int age, int salary) {
        teacherRepository.save(new Teacher(fullName, subject, age, salary));
    }

    @Override
    public Teacher read(Long id) {
        if (teacherRepository.findById(id).isPresent()) {
            return teacherRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void update(Long id, String fullName, String subject, int age, int salary) {
        if (teacherRepository.findById(id).isPresent()) {
            teacherRepository.save(teacherRepository.findById(id).get()
                    .setFullName(fullName)
                    .setSubject(subject)
                    .setAge(age)
                    .setSalary(salary)
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
