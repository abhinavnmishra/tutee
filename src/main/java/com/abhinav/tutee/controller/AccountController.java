package com.abhinav.tutee.controller;

import com.abhinav.tutee.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Secured({"ROLE_STUDENT", "ROLE_ADMIN"})
    @GetMapping("/getAccountInfo")
    public ResponseEntity<?> getAccountInfo(Principal principal) throws Exception {
        return new ResponseEntity<>(accountRepository.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @Secured({"ROLE_STUDENT", "ROLE_ADMIN"})
    @GetMapping("/isAuthenticated")
    public ResponseEntity<?> isAuthenticated() throws Exception  {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/getAllAccounts")
    public ResponseEntity<?> getAllAccounts() throws Exception  {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }

}
