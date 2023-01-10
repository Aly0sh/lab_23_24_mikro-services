package com.company.faculty.services;

import com.company.faculty.models.Faculty;

import java.util.List;

public interface iService {
    void create(String name, int price);
    Faculty read(Long id);
    void update(Long id, String name, int price);
    void delete(Long id);
    List<Faculty> getAll();
}
