package com.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a course holding a fixed-size roster of students.
 */
public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private final int courseId;
    private final String courseName;
    private final int capacity;
    private final List<Student> enrolledStudents;
    private final Student[] students; // simple fixed-size roster for Part 2 (kept for backward compatibility)
    private int count = 0;

    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.students = new Student[capacity];
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCapacity() { return capacity; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public int getNumberOfEnrolledStudents() { return enrolledStudents.size(); }
    public Student[] getStudents() { return students; }
    public int getCount() { return count; }

    /**
     * Add a student to this course if capacity allows.
     * @param student the student to enroll
     * @return true if enrolled successfully, false if course is full
     */
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() >= capacity) {
            return false;
        }
        enrolledStudents.add(student);
        // Also update the old array-based system for backward compatibility
        if (count < students.length) {
            students[count++] = student;
        }
        return true;
    }

    /**
     * Enroll a student if capacity allows.
     * @return true if enrolled
     */
    public boolean enrollStudent(Student s) {
        if (count >= students.length) return false;
        students[count++] = s;
        return true;
    }

    /**
     * Produce a simple roster string.
     */
    public String roster() {
        StringBuilder sb = new StringBuilder();
        sb.append("C").append(courseId).append(" - ").append(courseName).append(" (" ).append(count).append("/ ").append(students.length).append(")\n");
        for (int i = 0; i < count; i++) {
            sb.append("  ").append(i + 1).append(". ").append(students[i]).append("\n");
        }
        return sb.toString();
    }

    /**
     * Display detailed information about this course.
     */
    public void displayDetails() {
        System.out.println("Course ID: C" + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Enrolled Students: " + getNumberOfEnrolledStudents());
        System.out.println("Enrolled Students:");
        for (int i = 0; i < enrolledStudents.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + enrolledStudents.get(i).getName() + " (ID: " + enrolledStudents.get(i).getId() + ")");
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=C" + courseId +
                ", courseName='" + courseName + '\'' +
                ", enrolled=" + count +
                "/" + students.length +
                '}';
    }

    @Override
    public String toDataString() {
        // Format: courseId,courseName,capacity
        return courseId + "," + courseName + "," + capacity;
    }
}