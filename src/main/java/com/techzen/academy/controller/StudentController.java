package com.techzen.academy.controller;

import com.techzen.academy.Student;
import com.techzen.academy.dto.ApiResponse;
import com.techzen.academy.exception.ApiException;
import com.techzen.academy.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ApiResponse.builder().data(students).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable("id") UUID id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return ResponseEntity.ok(ApiResponse.<Student>builder()
                        .data(student)
                        .build());
            }
        }
        // exception ???
        /*
        Ngoai le -> throw ErrorCode.STUDENT_NOT_EXIST
         */
//        return ResponseEntity.status(ErrorCode.STUDENT_NOT_EXIST.getStatus()).body(ApiResponse.<Student>builder()
//                .code(ErrorCode.STUDENT_NOT_EXIST.getCode())
//                .message(ErrorCode.STUDENT_NOT_EXIST.getMessage())
//                .build());
        throw new ApiException(ErrorCode.TEACHER_NOT_EXIST); // AOP
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> create(@RequestBody Student student) {
        student.setId(UUID.randomUUID());
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Student>builder()
                .data(student)
                .build());
    }
}
