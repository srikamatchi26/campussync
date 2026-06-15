package com.campussync.campussync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import com.campussync.campussync.exception.ResourceNotFoundException;
@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Add a class to the timetable
    public Timetable addClass(Long studentId, Timetable timetable) {
        Student student = studentRepository.findById(studentId)
                // In addClass method
                .orElseThrow(() -> new ResourceNotFoundException("Student", studentId));
        timetable.setStudent(student);
        return timetableRepository.save(timetable);
    }

    // Get TODAY's classes — the main feature
    public List<Timetable> getTodayClasses() {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        return timetableRepository.findByDay(today);
    }

    // Get full weekly schedule for a student
    public List<Timetable> getStudentSchedule(Long studentId) {
        return timetableRepository.findByStudentId(studentId);
    }
}