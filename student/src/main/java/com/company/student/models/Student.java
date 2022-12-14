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

    public Student(){}

    public Student(String fullName, int age, int course, String group) {
        this.fullName = fullName;
        this.age = age;
        this.course = course;
        this.group = group;
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
}
