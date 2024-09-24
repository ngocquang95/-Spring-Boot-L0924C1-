package com.techzen.academy.controller;

import com.techzen.academy.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(UUID.randomUUID(), "Nguyễn Văn A", 5.6),
                    new Student(UUID.randomUUID(), "Nguyễn Văn B", 7.7),
                    new Student(UUID.randomUUID(), "Nguyễn Văn C", 8.2),
                    new Student(UUID.randomUUID(), "Nguyễn Văn D", 5.1)
            )
    );

    // @RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping
    public List<Student> getAll() {
        return students;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") UUID id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                // return ResponseEntity.status(HttpStatus.OK).body(student);
                return ResponseEntity.ok(student);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        student.setId(UUID.randomUUID());
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
