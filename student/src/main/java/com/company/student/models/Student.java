package com.company.student.models;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private int age;

    private int course;

    @Column(name = "group_name")
    private String group;

    @ManyToOne(cascade = CascadeType.ALL)
    private Faculty faculty;

    public Student(){}

    public Student(String fullName, int age, int course, String group, Faculty faculty) {
        this.fullName = fullName;
        this.age = age;
        this.course = course;
        this.group = group;
        this.faculty = faculty;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public Student setCourse(int course) {
        this.course = course;
        return this;
    }

    public Student setGroup(String group) {
        this.group = group;
        return this;
    }

    public Student setFaculty(Faculty faculty) {
        this.faculty = faculty;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public Faculty getFaculty() {
        return faculty;
    }
}
