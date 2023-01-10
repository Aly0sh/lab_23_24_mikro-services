package com.company.faculty.services;

import com.company.faculty.models.Faculty;
import com.company.faculty.repositories.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService implements iService {
    private final FacultyRepository facultyRepository;

    @Override
    public void create(String name, int price) {
        facultyRepository.save(new Faculty(name, price));
    }

    @Override
    public Faculty read(Long id) {
        if (facultyRepository.findById(id).isPresent()) {
            return facultyRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void update(Long id, String name, int price) {
        if (facultyRepository.findById(id).isPresent()) {
            facultyRepository.save(
                    facultyRepository.findById(id).get()
                            .setName(name)
                            .setPrice(price)
            );
        }
    }

    @Override
    public void delete(Long id) {
        if (facultyRepository.findById(id).isPresent()) {
            facultyRepository.delete(facultyRepository.findById(id).get());
        }
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
}
