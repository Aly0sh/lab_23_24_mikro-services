package com.company.student.services;

import com.company.student.models.Student;
import com.company.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService implements iService {
    private StudentRepository studentRepository;


    @Override
    public void create(String fullName, int age, int course, String group) {
        studentRepository.save(new Student(fullName, age, course, group));
    }

    @Override
    public Student read(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void update(Long id, String fullName, int age, int course, String group) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.save(
                    studentRepository.findById(id).get()
                            .setFullName(fullName)
                            .setAge(age)
                            .setCourse(course)
                            .setGroup(group)
            );
        }
    }

    @Override
    public void delete(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.delete(studentRepository.findById(id).get());
        }
    }
}
