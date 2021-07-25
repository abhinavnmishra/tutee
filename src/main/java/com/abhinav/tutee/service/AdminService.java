package com.abhinav.tutee.service;

import com.abhinav.tutee.dto.AllStatsDto;
import com.abhinav.tutee.dto.CreateOpeningDto;
import com.abhinav.tutee.dto.QueryStudentDto;
import com.abhinav.tutee.model.Academics;
import com.abhinav.tutee.model.Invite;
import com.abhinav.tutee.model.Opening;
import com.abhinav.tutee.model.Student;
import com.abhinav.tutee.model.consts.Skill;
import com.abhinav.tutee.repository.*;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

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

    @Autowired
    EmailService emailService;

    public AllStatsDto getAllStats(Principal principal){
        AllStatsDto dto = new AllStatsDto();
        List<List<Invite>> list = new ArrayList<>();
        List<Opening> openings = openingRepository.findAll();
        for (Opening opening : openings){
            List<Invite> invites = inviteRepository.getAllByOpening_Id(opening.getId());
            list.add(invites);
        }
        dto.setInvites(list);
        dto.setOpenings(openings);
        dto.setNoStudents(studentRepository.count());
        dto.setAdmin(adminRepository.getByAccount_Username(principal.getName()));
        dto.setSkills(Arrays.asList(Skill.values()));
        return dto;
    }

    public List<Student> createOpening(CreateOpeningDto createOpeningDto) throws EmailException, MessagingException {

        Opening opening = new Opening();
        opening.setCompany(createOpeningDto.getCompany());
        opening.setDescription(createOpeningDto.getDescription());
        opening.setDate(createOpeningDto.getDate());
        opening.setStatus(Boolean.FALSE);
        opening = openingRepository.save(opening);

        List<Student> students = new ArrayList<>();

        for(Integer id : createOpeningDto.getStudentIdList()){
            Student student = studentRepository.findById(id).get();
            Invite invite = new Invite();
            invite.setOpening(opening);
            invite.setStatus(Boolean.FALSE);
            invite.setStudent(student);
            inviteRepository.save(invite);
            students.add(student);
            emailService.invite(student.getEmail(), opening.getCompany(), student.getFirstName(), opening.getDate());
        }

        return students;
    }

    public List<Student> queryStudents(QueryStudentDto dto){
        List<Academics> academicsList = academicsRepository.getAllByCgpaIsGreaterThanEqual(dto.getGpa());
        List<Student> result = new ArrayList<>();
        for (Academics academics : academicsList){
            if (academics.getStudent().getSkills().containsAll(dto.getSkills())){
                result.add(academics.getStudent());
            }
        }
        return result;
    }

    public List<Student> getAllStudentsByOpeningId(Integer id){

        List<Invite> invites = inviteRepository.getAllByOpening_Id(id);
        List<Student> students = new ArrayList<>();
        for (Invite invite : invites){
            students.add(invite.getStudent());
        }
        return students;
    }

    public List<Student> updateOpening(CreateOpeningDto dto) throws MessagingException, EmailException{

        List<Student> students = getAllStudentsByOpeningId(dto.getId());
        Opening opening = openingRepository.getById(dto.getId());
        opening.setStatus(Boolean.TRUE);
        openingRepository.save(opening);
        for (Student student : students){
            Invite invite = inviteRepository.findAllByStudent_IdAndOpening_Id(student.getId(), dto.getId());
            if (dto.getStudentIdList().contains(student.getId())){
                invite.setStatus(Boolean.TRUE);
                emailService.success(student.getEmail(), invite.getOpening().getCompany(), student.getFirstName());
            }
            else {
                invite.setStatus(Boolean.FALSE);
            }
            inviteRepository.save(invite);
        }

        return students;

    }

}
