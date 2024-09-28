package com.techzen.academy.service;

import com.techzen.academy.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentService {
    List<Student> findAll();

    Student findById(UUID id);

    Student save(Student student);
}
