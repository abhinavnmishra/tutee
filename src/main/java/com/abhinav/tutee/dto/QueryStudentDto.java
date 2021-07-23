package com.abhinav.tutee.dto;

import com.abhinav.tutee.model.consts.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryStudentDto {

    private List<Skill> skills;
    private Float gpa;

}
