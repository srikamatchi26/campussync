package com.campussync.campussync;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudyGroupRepository
        extends JpaRepository<StudyGroup, Long> {

    // find all open groups
    List<StudyGroup> findByStatus(GroupStatus status);

    // find groups by topic (case insensitive)
    List<StudyGroup> findByTopicContainingIgnoreCase(String topic);

    // find open groups for a specific topic
    List<StudyGroup> findByTopicContainingIgnoreCaseAndStatus(
            String topic, GroupStatus status);
}