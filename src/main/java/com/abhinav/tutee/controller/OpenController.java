package com.abhinav.tutee.controller;

import com.abhinav.tutee.dto.CreateStudentDto;
import com.abhinav.tutee.model.Admin;
import com.abhinav.tutee.repository.AccountRepository;
import com.abhinav.tutee.service.AccountService;
import com.abhinav.tutee.service.AdminService;
import com.abhinav.tutee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping("/open")
public class OpenController {

    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(@RequestBody @Valid CreateStudentDto createStudentDto) {
        return new ResponseEntity<>(studentService.createStudent(createStudentDto), HttpStatus.OK);
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<>(accountService.createAdmin(admin), HttpStatus.OK);
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<?> getAllAccounts() throws Exception  {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getStudentInfo")
    public ResponseEntity<?> getStudentInfo(String username) throws Exception {
        return new ResponseEntity<>(studentService.studentDto(username), HttpStatus.OK);
    }

    @GetMapping("/wait")
    public ResponseEntity<?> wait(Integer a) throws Exception {

        try {
            TimeUnit.SECONDS.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new ResponseEntity<>("No", HttpStatus.OK);
        }

        return new ResponseEntity<>("Yes", HttpStatus.OK);
    }

    @GetMapping("/getReport")
    public ResponseEntity<?> getReport() throws Exception {
        return new ResponseEntity<>(adminService.getReport(), HttpStatus.OK);
    }

}
