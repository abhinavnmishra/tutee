package com.abhinav.tutee.model;

import com.abhinav.tutee.model.consts.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Account account;

    private String firstName;

    private String lastName;

    private Integer year;

    private String department;

    @Email
    private String email;

    @ElementCollection
    private List<Skill> skills = new ArrayList<>();

}
