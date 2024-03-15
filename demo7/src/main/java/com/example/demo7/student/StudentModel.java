package com.example.demo7.student;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentModel {

    private Integer id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer Age;
    private Integer months;
    private Integer days;
}

