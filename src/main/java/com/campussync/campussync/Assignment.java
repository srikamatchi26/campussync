package com.campussync.campussync;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subject;
    private String description;

    private LocalDate dueDate;     // stores date like 2025-06-15

    @Enumerated(EnumType.STRING)   // store "PENDING" not 0 or 1
    private AssignmentStatus status = AssignmentStatus.PENDING;
    // ↑ every new assignment starts as PENDING automatically

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // --- Constructors ---
    public Assignment() {}

    // --- Getters and Setters ---
    public Long getId()                      { return id; }
    public String getTitle()                 { return title; }
    public void setTitle(String t)           { this.title = t; }
    public String getSubject()               { return subject; }
    public void setSubject(String s)         { this.subject = s; }
    public String getDescription()           { return description; }
    public void setDescription(String d)     { this.description = d; }
    public LocalDate getDueDate()            { return dueDate; }
    public void setDueDate(LocalDate d)      { this.dueDate = d; }
    public AssignmentStatus getStatus()      { return status; }
    public void setStatus(AssignmentStatus s){ this.status = s; }
    public Student getStudent()              { return student; }
    public void setStudent(Student s)        { this.student = s; }
}