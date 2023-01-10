package com.company.student.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int price;

    public Faculty() {}

    public Faculty(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Faculty setName(String name) {
        this.name = name;
        return this;
    }

    public Faculty setPrice(int price) {
        this.price = price;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
