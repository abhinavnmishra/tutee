package com.abhinav.tutee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String orgName;

    private String role;

    private Date startDate;

    private Date endDate;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private Student student;

}
