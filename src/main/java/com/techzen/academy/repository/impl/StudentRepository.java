package com.techzen.academy.repository.impl;

import com.techzen.academy.model.Student;
import com.techzen.academy.repository.IStudentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentRepository implements IStudentRepository {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(UUID.randomUUID(), "Nguyễn Văn A", 5.6),
                    new Student(UUID.randomUUID(), "Nguyễn Văn B", 7.7),
                    new Student(UUID.randomUUID(), "Nguyễn Văn C", 8.2),
                    new Student(UUID.randomUUID(), "Nguyễn Văn D", 5.1)
            )
    );

    public List<Student> findAll() {
        return students;
    }

    public Student findById(UUID id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Student save(Student student) {
        student.setId(UUID.randomUUID());
        students.add(student);
        return student;
    }
}
