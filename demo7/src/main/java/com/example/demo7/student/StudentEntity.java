package com.example.demo7.student;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class StudentEntity{

    @Id
    private Integer id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
}
