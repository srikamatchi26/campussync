package com.campussync.campussync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/timetable")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    // POST /timetable/{studentId} → add a class
    @PostMapping("/{studentId}")
    public Timetable addClass(@PathVariable Long studentId,
                              @RequestBody Timetable timetable) {
        return timetableService.addClass(studentId, timetable);
    }

    // GET /timetable/today → today's classes
    @GetMapping("/today")
    public List<Timetable> getTodayClasses() {
        return timetableService.getTodayClasses();
    }

    // GET /timetable/student/1 → full schedule for student 1
    @GetMapping("/student/{studentId}")
    public List<Timetable> getStudentSchedule(@PathVariable Long studentId) {
        return timetableService.getStudentSchedule(studentId);
    }
}