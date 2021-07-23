package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> getAllByStudent_Account_Username(String username);
}
