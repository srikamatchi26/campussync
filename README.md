# CampusSync — College Life Companion REST API

A Spring Boot REST API that helps MCA students manage their college life —
timetable, assignments, and study groups — all in one backend.

## Features

- **Student Management** — register and manage student profiles
- **Timetable** — add weekly classes, instantly fetch "today's classes"
  using Java's LocalDate and DayOfWeek
- **Assignment Tracker** — track assignments with due dates, get a list
  of everything due this week, mark as completed
- **Study Groups** — create or join topic-based study groups
  (Many-to-Many relationship with auto-generated junction table)

## Tech Stack

- Java 17, Spring Boot 3.x
- Spring Data JPA, Hibernate
- MySQL
- REST APIs (tested with Postman)

## Architecture

Follows a layered architecture: Controller → Service → Repository → Entity

- Centralized exception handling via `@RestControllerAdvice`
- Custom exceptions: `ResourceNotFoundException`, `BadRequestException`
- Consistent API response format with status, message, data, timestamp

## API Endpoints

### Students
- `POST /students` — register a student
- `GET /students` — list all students
- `GET /students/{id}` — get student by id

### Timetable
- `POST /timetable/{studentId}` — add a class
- `GET /timetable/today` — get today's classes
- `GET /timetable/student/{id}` — full weekly schedule

### Assignments
- `POST /assignments/{studentId}` — add assignment
- `GET /assignments/pending/{studentId}` — pending assignments
- `GET /assignments/due` — assignments due this week
- `PUT /assignments/{id}/done` — mark as completed

### Study Groups
- `POST /studygroups/{studentId}` — create a study group
- `GET /studygroups` — browse open groups
- `GET /studygroups/topic/{topic}` — search by topic
- `POST /studygroups/{groupId}/join/{studentId}` — join a group
- `GET /studygroups/{groupId}/members` — view members

## How to Run Locally

1. Clone the repo
2. Create MySQL database: `CREATE DATABASE campussync;`
3. Copy `application.properties.example` to `application.properties`
   and update with your MySQL credentials
4. Run: `mvn spring-boot:run`
5. Base URL: `http://localhost:8080`

## Author

Srikmatchi — MCA, Anna University (CEG)