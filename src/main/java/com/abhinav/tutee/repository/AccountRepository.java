package com.abhinav.tutee.repository;

import com.abhinav.tutee.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.validation.constraints.NotNull;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(@NotNull(message = "username should not be null") String email);
}