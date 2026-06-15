package com.campussync.campussync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import com.campussync.campussync.exception.ResourceNotFoundException;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Add a new assignment
    public Assignment addAssignment(Long studentId, Assignment assignment) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));
        assignment.setStudent(student);
        // status is already PENDING by default — no need to set it
        return assignmentRepository.save(assignment);
    }

    // Get all PENDING assignments for a student
    public List<Assignment> getPendingAssignments(Long studentId) {
        return assignmentRepository.findByStudentIdAndStatus(
                studentId, AssignmentStatus.PENDING);
    }

    // Get assignments due THIS week — the smart feature
    public List<Assignment> getDueThisWeek() {
        LocalDate today = LocalDate.now();
        LocalDate endOfWeek = today.plusDays(7);
        // returns all PENDING assignments in next 7 days
        return assignmentRepository.findByStatusAndDueDateBetween(
                AssignmentStatus.PENDING, today, endOfWeek);
    }

    // Mark assignment as COMPLETED
    public Assignment markAsDone(Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment", assignmentId));
        assignment.setStatus(AssignmentStatus.COMPLETED);
        return assignmentRepository.save(assignment);
    }
}