package com.abhinav.tutee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDto {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Integer year;
    private String department;

}
