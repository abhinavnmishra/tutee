package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> getAllByStudent_Account_Username(String username);
}
