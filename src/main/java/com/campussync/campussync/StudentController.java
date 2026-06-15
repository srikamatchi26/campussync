package com.campussync.campussync;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.campussync.campussync.dto.ApiResponse;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // POST /students → create a student
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(
            @RequestBody Student student) {
        Student saved = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)           // 201
                .body(ApiResponse.success(
                        saved,
                        "Student registered successfully",
                        201));
    }
    // GET /students → get all students
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(
                ApiResponse.success(
                        students,
                        "Students fetched successfully",
                        200));
    }
    // GET /students/1 → get student with id 1
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(
            @PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(
                ApiResponse.success(
                        student,
                        "Student fetched successfully",
                        200));
    }
}