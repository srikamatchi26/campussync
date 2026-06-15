package com.campussync.campussync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.campussync.campussync.exception.ResourceNotFoundException;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Save a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get one student by id
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", id));
    }
}
