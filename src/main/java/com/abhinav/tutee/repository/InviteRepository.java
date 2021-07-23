package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Invite;
import com.abhinav.tutee.model.Opening;
import com.abhinav.tutee.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Integer> {
    List<Invite> getAllByOpening_Id(Integer id);
    List<Invite> findByOpening(Opening opening);
    Invite findAllByStudent_IdAndOpening_Id(Integer idStudent, Integer openingId);
    List<Invite> findAllByStudent_Id(Integer id);
}
