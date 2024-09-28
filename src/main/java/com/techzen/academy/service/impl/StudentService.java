package com.techzen.academy.service.impl;

import com.techzen.academy.model.Student;
import com.techzen.academy.repository.IStudentRepository;
import com.techzen.academy.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(UUID id) {
       return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
