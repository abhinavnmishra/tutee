package com.abhinav.tutee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Academics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float sem1;
    private Float sem2;
    private Float sem3;
    private Float sem4;
    private Float sem5;
    private Float sem6;
    private Float sem7;
    private Float sem8;
    private Float cgpa;

    private Float hsc;

    private Float ssc;

    @OneToOne
    private Student student;


}
