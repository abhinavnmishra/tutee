package com.abhinav.tutee.controller;

import com.abhinav.tutee.dto.CreateOpeningDto;
import com.abhinav.tutee.dto.QueryStudentDto;
import com.abhinav.tutee.repository.AdminRepository;
import com.abhinav.tutee.repository.OpeningRepository;
import com.abhinav.tutee.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    OpeningRepository openingRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAdminInfo")
    public ResponseEntity<?> getAdminInfo(Principal principal) throws Exception {
        return new ResponseEntity<>(adminRepository.getByAccount_Username(principal.getName()), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAllStats")
    public ResponseEntity<?> getAllStats() throws Exception {
        return new ResponseEntity<>(adminService.getAllStats(), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/allOpenings")
    public ResponseEntity<?> allOpenings() throws Exception {
        return new ResponseEntity<>(openingRepository.findAll(), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/createOpening")
    public ResponseEntity<?> createOpening(@RequestBody @Valid CreateOpeningDto createOpeningDto) {
        try{
            return new ResponseEntity<>(adminService.createOpening(createOpeningDto), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/updateOpening")
    public ResponseEntity<?> updateOpening(@RequestBody @Valid CreateOpeningDto createOpeningDto) {
        try{
            return new ResponseEntity<>(adminService.updateOpening(createOpeningDto), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/queryStudents")
    public ResponseEntity<?> queryStudent(@RequestBody @Valid QueryStudentDto queryStudentDto) {
        try{
            return new ResponseEntity<>(adminService.queryStudents(queryStudentDto), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}
