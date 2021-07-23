package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Academics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicsRepository extends JpaRepository<Academics, Integer> {
    List<Academics> getAllByCgpaIsGreaterThanEqual(Float cgpa);
    List<Academics> getAllByStudent_Account_Username(String username);
    Academics getByStudent_Account_Username(String username);
}
