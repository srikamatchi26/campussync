package com.campussync.campussync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // nothing needed here yet — JPA gives you 10+ methods for free
}