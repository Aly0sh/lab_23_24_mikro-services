package com.company.teacher.models;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String subject;

    private int age;

    private int salary;

    @ManyToOne
    private Faculty faculty;

    public Teacher() {}

    public Teacher(String fullName, String subject, int age, int salary, Faculty faculty) {
        this.fullName = fullName;
        this.subject = subject;
        this.age = age;
        this.salary = salary;
        this.faculty = faculty;
    }

    public Teacher setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Teacher setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Teacher setAge(int age) {
        this.age = age;
        return this;
    }

    public Teacher setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public Teacher setFaculty(Faculty faculty) {
        this.faculty = faculty;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSubject() {
        return subject;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public Faculty getFaculty() {
        return faculty;
    }
}
