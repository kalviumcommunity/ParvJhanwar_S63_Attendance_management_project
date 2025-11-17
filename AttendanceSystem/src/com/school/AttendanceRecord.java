package com.school;

/**
 * Represents an attendance record for a student in a course.
 */
public class AttendanceRecord implements Storable {
    private final Student student;
    private final Course course;
    private String status;

    /**
     * Create an attendance record with validation for status.
     * @param student the Student object
     * @param course the Course object
     * @param status the attendance status ("Present" or "Absent")
     */
    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        
        // Validate status (case-insensitive)
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            System.out.println("Warning: Invalid status '" + status + "' for student " + student.getId() + 
                             " in course " + course.getCourseId() + ". Setting status to 'Invalid'.");
            this.status = "Invalid";
        }
    }

    /**
     * Get the student object.
     * @return the Student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Get the course object.
     * @return the Course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Get the attendance status.
     * @return the attendance status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Display the attendance record information.
     */
    public void displayRecord() {
        System.out.println("Attendance Record - Student: " + student.getName() + 
                          " (ID: " + student.getId() + ")" +
                          ", Course: " + course.getCourseName() + 
                          " (C" + course.getCourseId() + ")" +
                          ", Status: " + status);
    }

    @Override
    public String toDataString() {
        // Format: studentId,courseId,status
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}