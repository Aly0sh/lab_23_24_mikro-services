package com.company.teacher.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String subject;

    private int age;

    private int salary;

    public Teacher() {}

    public Teacher(String fullName, String subject, int age, int salary) {
        this.fullName = fullName;
        this.subject = subject;
        this.age = age;
        this.salary = salary;
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
}
