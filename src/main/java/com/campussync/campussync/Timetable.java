package com.campussync.campussync;
import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String professor;
    private String room;

    private LocalTime startTime;  // stores time like 09:00
    private LocalTime endTime;    // stores time like 10:00

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;        // MONDAY, TUESDAY... SUNDAY

    @ManyToOne                    // many classes → one student
    @JoinColumn(name = "student_id")  // FK column name in DB
    private Student student;

    // --- Constructors ---
    public Timetable() {}

    // --- Getters and Setters ---
    public Long getId()                  { return id; }
    public String getSubject()           { return subject; }
    public void setSubject(String s)     { this.subject = s; }
    public String getProfessor()         { return professor; }
    public void setProfessor(String p)   { this.professor = p; }
    public String getRoom()              { return room; }
    public void setRoom(String r)        { this.room = r; }
    public LocalTime getStartTime()      { return startTime; }
    public void setStartTime(LocalTime t){ this.startTime = t; }
    public LocalTime getEndTime()        { return endTime; }
    public void setEndTime(LocalTime t)  { this.endTime = t; }
    public DayOfWeek getDay()            { return day; }
    public void setDay(DayOfWeek d)      { this.day = d; }
    public Student getStudent()          { return student; }
    public void setStudent(Student s)    { this.student = s; }
}
