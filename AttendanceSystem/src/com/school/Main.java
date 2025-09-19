package com.school;

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
    }
}