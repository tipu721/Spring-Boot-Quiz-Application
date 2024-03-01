package com.tipu.main.repository;

import com.tipu.main.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Integer> {
}
