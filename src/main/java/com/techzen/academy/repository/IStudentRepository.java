package com.techzen.academy.repository;

import com.techzen.academy.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentRepository {
    List<Student> findAll();

    Student findById(UUID id);

    Student save(Student student);
}
