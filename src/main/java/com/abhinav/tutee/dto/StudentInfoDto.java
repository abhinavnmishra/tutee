package com.abhinav.tutee.dto;

import com.abhinav.tutee.model.*;
import com.abhinav.tutee.model.consts.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoDto {

    private List<Certificate> certificates;
    private List<Experience> experiences;
    private List<Project> projects;
    private List<Invite> invites;
    private Academics academics;
    private Student student;
    private List<Skill> skills;

}
