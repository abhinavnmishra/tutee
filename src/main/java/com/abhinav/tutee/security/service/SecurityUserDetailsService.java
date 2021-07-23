package com.abhinav.tutee.security.service;



import com.abhinav.tutee.model.Account;
import com.abhinav.tutee.repository.AccountRepository;
import com.abhinav.tutee.security.model.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = Optional.ofNullable(accountRepository.findByUsername(username));
        accountOptional.orElseThrow(() -> new UsernameNotFoundException("No User Found"));
        return accountOptional.map(SecurityUserDetails::new).get();
    }
}
