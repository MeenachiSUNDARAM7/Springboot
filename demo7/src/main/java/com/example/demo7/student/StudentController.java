package com.example.demo7.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentModel> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudents(@RequestBody StudentEntity student){
        studentService.addNewStudent(student);
    }


}
