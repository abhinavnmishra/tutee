package com.abhinav.tutee.service;

import com.abhinav.tutee.dto.CreateStudentDto;
import com.abhinav.tutee.dto.StudentInfoDto;
import com.abhinav.tutee.model.*;
import com.abhinav.tutee.model.consts.AccountRole;
import com.abhinav.tutee.model.consts.Skill;
import com.abhinav.tutee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

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

    @Autowired
    InviteRepository inviteRepository;

    @Autowired
    AccountService accountService;

    public Student createStudent(CreateStudentDto studentDto){
        Account account = accountService.createAccount(studentDto.getUsername(), studentDto.getPassword(), AccountRole.ROLE_STUDENT);
        Student student = new Student();
        student.setAccount(account);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setYear(studentDto.getYear());
        student.setDepartment(studentDto.getDepartment());

        return studentRepository.save(student);
    }

    public StudentInfoDto studentDto(String name){
        StudentInfoDto studentInfoDto = new StudentInfoDto();

        Student student = studentRepository.getByAccount_Username(name);
        List<Invite> invites = inviteRepository.findAllByStudent_Id(student.getId());
        List<Experience> experiences = experienceRepository.getAllByStudent_Account_Username(name);
        List<Project> projects = projectRepository.getAllByStudent_Account_Username(name);
        List<Certificate> certificates = certificateRepository.getAllByStudent_Account_Username(name);
        List<Academics> academics = academicsRepository.getAllByStudent_Account_Username(name);

        if (!academics.isEmpty()){
            studentInfoDto.setAcademics(academics.get(0));
        }
        else {
            studentInfoDto.setAcademics(new Academics());
        }
        studentInfoDto.setCertificates(certificates);
        studentInfoDto.setExperiences(experiences);
        studentInfoDto.setProjects(projects);
        studentInfoDto.setInvites(invites);
        studentInfoDto.setStudent(student);
        studentInfoDto.setSkills(Arrays.asList(Skill.values()));

        return studentInfoDto;

    }

    public Academics addAcademics(Principal principal, Academics academics){
        Student student = studentRepository.getByAccount_Username(principal.getName());
        Academics academics1;
        if (academics.getId() == null){
            academics1 = new Academics();
        }
        else {
            academics1 = academicsRepository.getById(academics.getId());
        }

        academics1.setHsc(academics.getHsc());
        academics1.setSsc(academics.getSsc());
        academics1.setSem1(academics.getSem1());
        academics1.setSem2(academics.getSem2());
        academics1.setSem3(academics.getSem3());
        academics1.setSem4(academics.getSem4());
        academics1.setSem5(academics.getSem5());
        academics1.setSem6(academics.getSem6());
        academics1.setSem7(academics.getSem7());
        academics1.setSem8(academics.getSem8());
        academics1.setCgpa(academics.getCgpa());
        academics1.setStudent(student);

        return academicsRepository.save(academics1);
    }

    public Student addSkills(Principal principal, List<Skill> skills){
        Student student = studentRepository.getByAccount_Username(principal.getName());
        student.setSkills(skills);
        return studentRepository.save(student);
    }

    public List<Experience> addExperience(Principal principal, List<Experience> experiences){
        Student student = studentRepository.getByAccount_Username(principal.getName());
        List<Experience> experienceList = new ArrayList<>();

        for (Experience experience : experiences) {
            experience.setStudent(student);
            experienceList.add(experienceRepository.save(experience));
        }
        return experienceList;
    }

    public List<Project> addProjects(Principal principal, List<Project> projects){
        Student student = studentRepository.getByAccount_Username(principal.getName());
        List<Project> projectList = new ArrayList<>();

        for (Project project : projects){
            project.setStudent(student);
            projectList.add(projectRepository.save(project));
        }
        return projectList;
    }

    public List<Certificate> addCertificates(Principal principal, List<Certificate> certificates){
        Student student = studentRepository.getByAccount_Username(principal.getName());
        List<Certificate> certificateList = new ArrayList<>();

        for (Certificate certificate: certificates){
            certificate.setStudent(student);
            certificateList.add(certificateRepository.save(certificate));
        }
        return certificateList;
    }

    public List<Invite> getAllInvites(Principal principal){
        Student student = studentRepository.getByAccount_Username(principal.getName());
        return inviteRepository.findAllByStudent_Id(student.getId());
    }

}