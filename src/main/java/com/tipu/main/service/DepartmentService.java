package com.tipu.main.service;

import com.tipu.main.model.Department;
import com.tipu.main.repository.DepartmentRepo;
import com.tipu.main.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;
    public void save(Department department) {
        departmentRepo.save(department);
    }

    public List<Department> getList() {
        return departmentRepo.findAll();
    }
}
