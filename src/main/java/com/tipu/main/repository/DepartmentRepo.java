package com.tipu.main.repository;

import com.tipu.main.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {


    @Query( value = "SELECT * FROM department ORDER BY ?3 LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Department> findByPage(Integer start, Integer pageLength, Integer sortColumnNo);

    @Query( value = "SELECT COUNT(ID) FROM department", nativeQuery = true)
    Integer countById();


}
