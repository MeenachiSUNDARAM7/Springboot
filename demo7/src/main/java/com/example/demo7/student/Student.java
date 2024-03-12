package com.example.demo7.student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class Student {
    @Id
    private Integer id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

}
