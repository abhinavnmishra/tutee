package com.abhinav.tutee.dto;

import com.abhinav.tutee.model.Admin;
import com.abhinav.tutee.model.Invite;
import com.abhinav.tutee.model.Opening;
import com.abhinav.tutee.model.consts.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllStatsDto {

    private List<List<Invite>> invites;
    private List<Opening> openings;
    private Long noStudents;
    private Admin admin;
    private List<Skill> skills;

}
