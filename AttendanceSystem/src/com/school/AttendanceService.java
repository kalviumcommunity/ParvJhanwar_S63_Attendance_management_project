package com.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to manage attendance records with overloaded methods and persistence.
 */
public class AttendanceService {
    private final List<AttendanceRecord> attendanceLog;
    private final FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    /**
     * Mark attendance by Student and Course objects.
     */
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord rec = new AttendanceRecord(student, course, status);
        attendanceLog.add(rec);
    }

    /**
     * Mark attendance by IDs. Looks up objects in provided lists then delegates.
     */
    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student s = findStudentById(studentId, allStudents);
        Course c = findCourseById(courseId, allCourses);
        if (s == null) {
            System.err.println("Student with ID " + studentId + " not found. Skipping record.");
            return;
        }
        if (c == null) {
            System.err.println("Course with ID " + courseId + " not found. Skipping record.");
            return;
        }
        markAttendance(s, c, status);
    }

    private Student findStudentById(int id, List<Student> allStudents) {
        if (allStudents == null) return null;
        for (Student s : allStudents) {
            if (s.getStudentId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        if (allCourses == null) return null;
        for (Course c : allCourses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public void displayAttendanceLog() {
        System.out.println("\n--- Attendance Log (all records) ---");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance Log for student: " + student.getName() + " (ID: " + student.getId() + ") ---");
        for (AttendanceRecord r : attendanceLog) {
            if (r.getStudent().getId() == student.getId()) r.displayRecord();
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance Log for course: " + course.getCourseName() + " (C" + course.getCourseId() + ") ---");
        for (AttendanceRecord r : attendanceLog) {
            if (r.getCourse().getCourseId() == course.getCourseId()) r.displayRecord();
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
