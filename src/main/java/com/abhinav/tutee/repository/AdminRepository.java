package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin getByAccount_Username(String username);
}
