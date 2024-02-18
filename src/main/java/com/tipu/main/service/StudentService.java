package com.tipu.main.service;

import com.tipu.main.model.Student;
import com.tipu.main.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public void save(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getList() {
        return studentRepo.findAll();
    }
}
