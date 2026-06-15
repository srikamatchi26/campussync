package com.campussync.campussync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.campussync.campussync.dto.ApiResponse;

@RestController
@RequestMapping("/studygroups")
public class StudyGroupController {

    @Autowired
    private StudyGroupService studyGroupService;

    // POST /studygroups/1 → student 1 creates a group
    @PostMapping("/{studentId}")
    public StudyGroup createGroup(
            @PathVariable Long studentId,
            @RequestBody StudyGroup group) {
        return studyGroupService.createGroup(studentId, group);
    }

    // GET /studygroups → all open groups
    @GetMapping
    public List<StudyGroup> getAllOpen() {
        return studyGroupService.getAllOpenGroups();
    }

    // GET /studygroups/topic/DSA → search by topic
    @GetMapping("/topic/{topic}")
    public List<StudyGroup> getByTopic(@PathVariable String topic) {
        return studyGroupService.findByTopic(topic);
    }

    // POST /studygroups/1/join/2 → student 2 joins group 1
    @PostMapping("/{groupId}/join/{studentId}")
    public ResponseEntity<ApiResponse<StudyGroup>> joinGroup(
            @PathVariable Long groupId,
            @PathVariable Long studentId) {
        StudyGroup group = studyGroupService.joinGroup(groupId, studentId);
        return ResponseEntity.ok(
                ApiResponse.success(
                        group,
                        "Successfully joined the study group",
                        200));
    }

    // GET /studygroups/1/members → who's in group 1
    @GetMapping("/{groupId}/members")
    public List<Student> getMembers(@PathVariable Long groupId) {
        return studyGroupService.getGroupMembers(groupId);
    }
}