package com.campussync.campussync;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    // all pending assignments for a student
    List<Assignment> findByStudentIdAndStatus(
            Long studentId, AssignmentStatus status);

    // assignments due between two dates — for "due this week"
    List<Assignment> findByDueDateBetween(
            LocalDate start, LocalDate end);

    // pending assignments due between two dates
    List<Assignment> findByStatusAndDueDateBetween(
            AssignmentStatus status, LocalDate start, LocalDate end);
}