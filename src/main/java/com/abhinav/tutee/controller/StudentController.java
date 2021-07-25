package com.abhinav.tutee.controller;

import com.abhinav.tutee.model.Academics;
import com.abhinav.tutee.model.Certificate;
import com.abhinav.tutee.model.Experience;
import com.abhinav.tutee.model.Project;
import com.abhinav.tutee.model.consts.Skill;
import com.abhinav.tutee.repository.*;
import com.abhinav.tutee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    AcademicsRepository academicsRepository;

    @Autowired
    OpeningRepository openingRepository;


    @Secured("ROLE_STUDENT")
    @GetMapping("/getStudent")
    public ResponseEntity<?> getStudent(Principal principal) throws Exception {
        return new ResponseEntity<>(studentRepository.getByAccount_Username(principal.getName()), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @GetMapping("/getStudentInfo")
    public ResponseEntity<?> getStudentInfo(Principal principal) throws Exception {
        return new ResponseEntity<>(studentService.studentDto(principal.getName()), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @GetMapping("/getAllInvites")
    public ResponseEntity<?> getAllInvites(Principal principal) throws Exception {
        return new ResponseEntity<>(studentService.getAllInvites(principal), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @PostMapping("/academics")
    public ResponseEntity<?> addAcademics(Principal principal, @RequestBody @Valid Academics academics) throws Exception {
        return new ResponseEntity<>(studentService.addAcademics(principal, academics), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @GetMapping("/allAcademics")
    public ResponseEntity<?> allAcademics(Principal principal) throws Exception {
        return new ResponseEntity<>(academicsRepository.getAllByStudent_Account_Username(principal.getName()), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @PostMapping("/skills")
    public ResponseEntity<?> addSkills(Principal principal, @RequestBody List<Skill> skills) throws Exception {
        return new ResponseEntity<>(studentService.addSkills(principal, skills), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @PostMapping("/experience")
    public ResponseEntity<?> addExperience(Principal principal, @RequestBody @Valid List<Experience> experiences) throws Exception {
        return new ResponseEntity<>(studentService.addExperience(principal, experiences), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @GetMapping("/allExperience")
    public ResponseEntity<?> allExperience(Principal principal) throws Exception {
        return new ResponseEntity<>(experienceRepository.getAllByStudent_Account_Username(principal.getName()), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @PostMapping("/projects")
    public ResponseEntity<?> addProjects(Principal principal, @RequestBody @Valid List<Project> projects) throws Exception {
        return new ResponseEntity<>(studentService.addProjects(principal, projects), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @GetMapping("/allProjects")
    public ResponseEntity<?> allProjects(Principal principal) throws Exception {
        return new ResponseEntity<>(projectRepository.getAllByStudent_Account_Username(principal.getName()), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @PostMapping("/certificates")
    public ResponseEntity<?> addCertificates(Principal principal, @RequestBody @Valid List<Certificate> certificates) throws Exception {
        return new ResponseEntity<>(studentService.addCertificates(principal, certificates), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @GetMapping("/allCertificates")
    public ResponseEntity<?> allCertificates(Principal principal) throws Exception {
        return new ResponseEntity<>(certificateRepository.getAllByStudent_Account_Username(principal.getName()), HttpStatus.OK);
    }

    @Secured("ROLE_STUDENT")
    @GetMapping("/allSkills")
    public ResponseEntity<?> allSkills(Principal principal) throws Exception {
        return new ResponseEntity<>(Skill.values(), HttpStatus.OK);
    }

}
