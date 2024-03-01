package com.tipu.main.service;

import com.tipu.main.model.Faculty;
import com.tipu.main.repository.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacultyService {

    @Autowired
    FacultyRepo facultyRepo;
    public void save(Faculty faculty) {
        facultyRepo.save(faculty);
    }

    public List<Faculty> getList() {
        return facultyRepo.findAll();
    }
}
