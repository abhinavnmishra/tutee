package com.abhinav.tutee.test;

import com.abhinav.tutee.dto.CreateStudentDto;
import com.abhinav.tutee.model.Admin;
import com.abhinav.tutee.repository.AccountRepository;
import com.abhinav.tutee.service.AccountService;
import com.abhinav.tutee.service.AdminService;
import com.abhinav.tutee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

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
        try{
            return new ResponseEntity<>(studentService.createStudent(createStudentDto), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<>(accountService.createAdmin(admin), HttpStatus.OK);
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<?> getAllAccounts() throws Exception  {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }



}
