package com.company.student.services;

import com.company.student.models.Student;
import com.company.student.repositories.FacultyRepository;
import com.company.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements iService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    @Override
    public void create(String fullName, int age, int course, String group, Long faculty_id) {
        studentRepository.save(new Student(fullName, age, course, group, facultyRepository.findById(faculty_id).get()));
    }

    @Override
    public Student read(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void update(Long id, String fullName, int age, int course, String group, Long faculty_id) {
        if (studentRepository.findById(id).isPresent() && facultyRepository.findById(faculty_id).isPresent()) {
            studentRepository.save(
                    studentRepository.findById(id).get()
                            .setFullName(fullName)
                            .setAge(age)
                            .setCourse(course)
                            .setGroup(group)
                            .setFaculty(facultyRepository.findById(faculty_id).get())
            );
        }
    }

    @Override
    public void delete(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.delete(studentRepository.findById(id).get());
        }
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
