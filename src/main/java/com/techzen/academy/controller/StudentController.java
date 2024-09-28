package com.techzen.academy.controller;

import com.techzen.academy.dto.ApiResponse;
import com.techzen.academy.exception.ApiException;
import com.techzen.academy.exception.ErrorCode;
import com.techzen.academy.model.Student;
import com.techzen.academy.service.IStudentService;
import com.techzen.academy.service.impl.StudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(ApiResponse.builder()
                .data(studentService.findAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable("id") UUID id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new ApiException(ErrorCode.STUDENT_NOT_EXIST);
        }

        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Student>builder()
                .data(studentService.save(student))
                .build());
    }
}
