package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Opening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpeningRepository extends JpaRepository<Opening, Integer> {
}
