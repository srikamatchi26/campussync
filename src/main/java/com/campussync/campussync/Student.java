package com.campussync.campussync;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private int year;
    private double cgpa;

    // --- Constructors ---
    public Student() {}   // JPA needs this empty one

    public Student(String name, String email,
                   String department, int year, double cgpa) {
        this.name       = name;
        this.email      = email;
        this.department = department;
        this.year       = year;
        this.cgpa       = cgpa;
    }

    // --- Getters and Setters ---
    public Long getId()             { return id; }
    public String getName()         { return name; }
    public void setName(String n)   { this.name = n; }
    public String getEmail()        { return email; }
    public void setEmail(String e)  { this.email = e; }
    public String getDepartment()   { return department; }
    public void setDepartment(String d) { this.department = d; }
    public int getYear()            { return year; }
    public void setYear(int y)      { this.year = y; }
    public double getCgpa()         { return cgpa; }
    public void setCgpa(double c)   { this.cgpa = c; }

}
