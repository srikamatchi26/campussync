package com.campussync.campussync;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.DayOfWeek;
import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    // get all classes for a specific student
    List<Timetable> findByStudentId(Long studentId);

    // get classes for a specific day — this is the "today" feature
    List<Timetable> findByDay(DayOfWeek day);

    // get classes for a specific student on a specific day
    List<Timetable> findByStudentIdAndDay(Long studentId, DayOfWeek day);
}