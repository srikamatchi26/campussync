package com.campussync.campussync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.campussync.campussync.exception.ResourceNotFoundException;
import com.campussync.campussync.exception.BadRequestException;

@Service
public class StudyGroupService {

    @Autowired
    private StudyGroupRepository studyGroupRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Create a new study group
    public StudyGroup createGroup(Long studentId, StudyGroup group) {
        Student creator = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));
        group.setCreatedBy(creator);
        group.getMembers().add(creator); // creator auto-joins their own group
        return studyGroupRepository.save(group);
    }

    // Get all open groups
    public List<StudyGroup> getAllOpenGroups() {
        return studyGroupRepository.findByStatus(GroupStatus.OPEN);
    }

    // Search groups by topic
    public List<StudyGroup> findByTopic(String topic) {
        return studyGroupRepository
                .findByTopicContainingIgnoreCaseAndStatus(
                        topic, GroupStatus.OPEN);
    }

    // Join a study group — the core Many-to-Many action
    public StudyGroup joinGroup(Long groupId, Long studentId) {
        StudyGroup group = studyGroupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("StudyGroup", groupId));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));

        // check 1 — is group open?
        if (group.getStatus() != GroupStatus.OPEN) {
            throw new BadRequestException("Group is not open for joining");
        }

        // check 2 — already a member?
        if (group.getMembers().contains(student)) {
            throw new BadRequestException("Student already in this group");
        }

        // add student to group
        group.getMembers().add(student);

        // check 3 — is group full now?
        if (group.getMembers().size() >= group.getMaxMembers()) {
            group.setStatus(GroupStatus.FULL); // auto-close when full
        }

        return studyGroupRepository.save(group);
    }

    // Get all members of a group
    public List<Student> getGroupMembers(Long groupId) {
        StudyGroup group = studyGroupRepository.findById(groupId)
                .orElseThrow(() ->
                        new RuntimeException("Group not found: " + groupId));
        return group.getMembers();
    }
}