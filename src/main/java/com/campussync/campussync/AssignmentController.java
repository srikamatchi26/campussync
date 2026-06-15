package com.campussync.campussync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.campussync.campussync.dto.ApiResponse;


@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // POST /assignments/1 → add assignment for student 1
    @PostMapping("/{studentId}")
    public Assignment addAssignment(
            @PathVariable Long studentId,
            @RequestBody Assignment assignment) {
        return assignmentService.addAssignment(studentId, assignment);
    }

    // GET /assignments/pending/1 → all pending for student 1
    @GetMapping("/pending/{studentId}")
    public List<Assignment> getPending(@PathVariable Long studentId) {
        return assignmentService.getPendingAssignments(studentId);
    }

    // GET /assignments/due → due this week
    @GetMapping("/due")
    public List<Assignment> getDueThisWeek() {
        return assignmentService.getDueThisWeek();
    }

    // PUT /assignments/1/done → mark assignment 1 as done
    @PutMapping("/{id}/done")
    public ResponseEntity<ApiResponse<Assignment>> markDone(
            @PathVariable Long id) {
        Assignment updated = assignmentService.markAsDone(id);
        return ResponseEntity.ok(
                ApiResponse.success(
                        updated,
                        "Assignment marked as completed",
                        200));
    }
}