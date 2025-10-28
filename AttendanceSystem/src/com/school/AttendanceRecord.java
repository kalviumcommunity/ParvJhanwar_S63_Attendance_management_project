package com.school;

/**
 * Represents an attendance record for a student in a course.
 */
public class AttendanceRecord implements Storable {
    private final int studentId;
    private final int courseId;
    private String status;

    /**
     * Create an attendance record with validation for status.
     * @param studentId the ID of the student
     * @param courseId the ID of the course
     * @param status the attendance status ("Present" or "Absent")
     */
    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        
        // Validate status (case-insensitive)
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            System.out.println("Warning: Invalid status '" + status + "' for student " + studentId + 
                             " in course " + courseId + ". Setting status to 'Invalid'.");
            this.status = "Invalid";
        }
    }

    /**
     * Get the student ID.
     * @return the student ID
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Get the course ID.
     * @return the course ID
     */
    public int getCourseId() {
        return courseId;
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
        System.out.println("Attendance Record - Student ID: " + studentId + 
                          ", Course ID: C" + courseId + 
                          ", Status: " + status);
    }

    @Override
    public String toDataString() {
        // Format: studentId,courseId,status
        return studentId + "," + courseId + "," + status;
    }
}