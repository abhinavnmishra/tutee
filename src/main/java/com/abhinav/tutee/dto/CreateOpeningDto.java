package com.abhinav.tutee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOpeningDto {

    private Integer id;
    private String company;
    private String description;
    private List<Integer> studentIdList;
    private Date date;
    private Boolean status;

}
