package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    /**
     * Display details of all persons in the school directory using polymorphism.
     * @param people list of Person objects (can be Student, Teacher, or Staff)
     */
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory (Polymorphic Display) ===");
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }
    
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

        // Create a Teacher
        Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
        
        // Create a Staff member
        Staff staff1 = new Staff("Mrs. Johnson", "Administrator");
        
        // Create another Staff member
        Staff staff2 = new Staff("Mr. Brown", "Maintenance");
        
        // Create school directory with all persons
        ArrayList<Person> schoolPeople = new ArrayList<>();
        for (Student s : students) {
            schoolPeople.add(s);
        }
        schoolPeople.add(teacher1);
        schoolPeople.add(staff1);
        schoolPeople.add(staff2);
        
        // Display school directory using polymorphism
        displaySchoolDirectory(schoolPeople);

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

        // Create attendance records using Student and Course objects
        attendanceLog.add(new AttendanceRecord(students[0], course1, "Present"));
        attendanceLog.add(new AttendanceRecord(students[1], course1, "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2], course2, "Present"));
        attendanceLog.add(new AttendanceRecord(students[3], course2, "InvalidStatus")); // Test validation
        attendanceLog.add(new AttendanceRecord(students[0], course2, "absent")); // Test case-insensitive

        // Display all attendance records
        System.out.println("\nAttendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Persist data to files using FileStorageService
        // Filter students from schoolPeople list
        ArrayList<Student> studentsList = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentsList.add((Student) p);
            }
        }

        ArrayList<Course> coursesList = new ArrayList<>();
        coursesList.add(course1);
        coursesList.add(course2);

        FileStorageService storage = new FileStorageService();
        storage.saveData(studentsList, "students.txt");
        storage.saveData(coursesList, "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nData saved: students.txt, courses.txt, attendance_log.txt");
    }
}