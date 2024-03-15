package com.example.demo7.student;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<StudentEntity, Id> {

    @Query("SELECT s FROM StudentEntity s WHERE s.email = ?1")
    Optional<StudentEntity> findStudentByEmail(String email);

    boolean existsById(Integer studentId);

}
