package com.tipu.main.repository;

import com.tipu.main.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {


    @Query( value = "SELECT * FROM department LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Department> findByPage(Integer pageNo, Integer pageLength);
}
