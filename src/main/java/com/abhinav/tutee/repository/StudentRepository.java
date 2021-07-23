package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Academics;
import com.abhinav.tutee.model.Invite;
import com.abhinav.tutee.model.Student;
import com.abhinav.tutee.model.consts.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student getByAccount_Username(String username);
}