package com.example.demo7.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentModel> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();

        List<StudentModel> studentModels = new ArrayList<>();

        for (StudentEntity entity : studentEntities) {
            StudentModel model = new StudentModel();
            model.setId(entity.getId());
            model.setName(entity.getName());
            model.setEmail(entity.getEmail());
            model.setDob(entity.getDob());

            // Calculate age, months, and days
            LocalDate today = LocalDate.now();
            Period agePeriod = Period.between(entity.getDob(), today);
            model.setAge(agePeriod.getYears());
            model.setMonths(agePeriod.getMonths());
            model.setDays(agePeriod.getDays());

            studentModels.add(model);
        }

        return studentModels;
    }



    public void addNewStudent(StudentEntity studententities) {
        Optional<StudentEntity> studentEntityOptional = studentRepository
                .findStudentByEmail(studententities.getEmail());
        if (studentEntityOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(studententities);
    }

}
