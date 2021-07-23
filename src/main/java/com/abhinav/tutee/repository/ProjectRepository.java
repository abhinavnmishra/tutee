package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> getAllByStudent_Account_Username(String username);
}
