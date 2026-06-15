package com.campussync.campussync;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_groups")
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private String description;
    private int maxMembers;

    @Enumerated(EnumType.STRING)
    private GroupStatus status = GroupStatus.OPEN;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Student createdBy;       // who created this group

    @ManyToMany                      // ← the new relationship
    @JoinTable(
            name = "student_groups",     // junction table name
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> members = new ArrayList<>();

    // --- Constructors ---
    public StudyGroup() {}

    // --- Getters and Setters ---
    public Long getId()                      { return id; }
    public String getTopic()                 { return topic; }
    public void setTopic(String t)           { this.topic = t; }
    public String getDescription()           { return description; }
    public void setDescription(String d)     { this.description = d; }
    public int getMaxMembers()               { return maxMembers; }
    public void setMaxMembers(int m)         { this.maxMembers = m; }
    public GroupStatus getStatus()           { return status; }
    public void setStatus(GroupStatus s)     { this.status = s; }
    public LocalDateTime getCreatedAt()      { return createdAt; }
    public Student getCreatedBy()            { return createdBy; }
    public void setCreatedBy(Student s)      { this.createdBy = s; }
    public List<Student> getMembers()        { return members; }
    public void setMembers(List<Student> m)  { this.members = m; }
}