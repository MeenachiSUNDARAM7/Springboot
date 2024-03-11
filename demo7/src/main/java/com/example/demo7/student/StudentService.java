package com.example.demo7.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRespository;

    public List<Student> getStudents() {
        return studentRespository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRespository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRespository.save(student);
    }

}
