package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Attendance Management System!");

    // Create sample students (assume 5 sessions)
    Student[] students = new Student[]{
        new Student("Alice", 5),
        new Student("Bob", 5),
        new Student("Charlie", 5),
        new Student("David", 5),
        new Student("Eva", 5)
    };

        // Mark some attendance
        students[0].markAttendance(0, true);
        students[0].markAttendance(1, true);
        students[1].markAttendance(0, false);
        students[2].markAttendance(0, true);

        // Create courses
    Course course1 = new Course("Intro to CS", 5);
    Course course2 = new Course("Discrete Math", 5);

        // Enroll students
        for (Student s : students) {
            course1.enrollStudent(s);
        }
        course2.enrollStudent(students[0]);
        course2.enrollStudent(students[2]);
        course2.enrollStudent(students[3]);

        // Print rosters
        System.out.println("\nCourse Rosters:");
        System.out.println(course1.roster());
        System.out.println(course2.roster());

        // Show auto-generated IDs
        System.out.println("\nStudent IDs:");
        for (Student s : students) {
            System.out.println(s.getStudentId() + ": " + s.getName());
        }
        System.out.println("\nCourse IDs:");
        System.out.println("Course 1: C" + course1.getCourseId() + " - " + course1.getCourseName());
        System.out.println("Course 2: C" + course2.getCourseId() + " - " + course2.getCourseName());

        // Create attendance log using ArrayList
        System.out.println("\n=== Attendance Records ===");
        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create attendance records (including one with invalid status for testing)
        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), course1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(), course1.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(), course2.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[3].getStudentId(), course2.getCourseId(), "InvalidStatus")); // Test validation
        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), course2.getCourseId(), "absent")); // Test case-insensitive

        // Display all attendance records
        System.out.println("\nAttendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Demonstrate Inheritance Hierarchy (Part 5)
        System.out.println("\n=== Inheritance Hierarchy - Person and Subclasses ===");
        
        // Create a Teacher
        Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
        
        // Create a Staff member
        Staff staff1 = new Staff("Mrs. Johnson", "Administrator");
        
        // Create another Staff member
        Staff staff2 = new Staff("Mr. Brown", "Maintenance");
        
        // Display details of all types of persons
        System.out.println("\nPerson Details:");
        System.out.println("--- Student ---");
        students[0].displayDetails();
        
        System.out.println("\n--- Teacher ---");
        teacher1.displayDetails();
        
        System.out.println("\n--- Staff Members ---");
        staff1.displayDetails();
        System.out.println();
        staff2.displayDetails();
        
        // Demonstrate polymorphism using Person reference
        System.out.println("\n--- Polymorphic Display (Person references) ---");
        Person[] persons = {students[0], teacher1, staff1};
        for (Person p : persons) {
            p.displayDetails();
            System.out.println();
        }
    }
}