package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    /**
     * Display details of all persons in the school directory using polymorphism.
     * @param registrationService the registration service containing all people
     */
    public static void displaySchoolDirectory(RegistrationService registrationService) {
        System.out.println("\n=== School Directory (Polymorphic Display) ===");
        List<Person> people = registrationService.getAllPeople();
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Attendance Management System!");

        // Instantiate services with dependency injection
        FileStorageService storage = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, registrationService);

        // Create sample students (assume 5 sessions)
        Student student1 = new Student("Alice", 5);
        Student student2 = new Student("Bob", 5);
        Student student3 = new Student("Charlie", 5);
        Student student4 = new Student("David", 5);
        Student student5 = new Student("Eva", 5);

        // Register students
        registrationService.registerStudent(student1);
        registrationService.registerStudent(student2);
        registrationService.registerStudent(student3);
        registrationService.registerStudent(student4);
        registrationService.registerStudent(student5);

        // Mark some attendance
        student1.markAttendance(0, true);
        student1.markAttendance(1, true);
        student2.markAttendance(0, false);
        student3.markAttendance(0, true);

        // Create courses with capacity
        Course course1 = registrationService.createCourse("Intro to CS", 5);
        Course course2 = registrationService.createCourse("Discrete Math", 3);

        // Create and register teachers
        Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
        registrationService.registerTeacher(teacher1);
        
        // Create and register staff members
        Staff staff1 = new Staff("Mrs. Johnson", "Administrator");
        Staff staff2 = new Staff("Mr. Brown", "Maintenance");
        registrationService.registerStaff(staff1);
        registrationService.registerStaff(staff2);
        
        // Display school directory using polymorphism
        displaySchoolDirectory(registrationService);

        // Enroll students using registrationService
        System.out.println("\n=== Enrolling Students in Courses ===");
        registrationService.enrollStudentInCourse(student1, course1);
        registrationService.enrollStudentInCourse(student2, course1);
        registrationService.enrollStudentInCourse(student3, course1);
        registrationService.enrollStudentInCourse(student4, course1);
        registrationService.enrollStudentInCourse(student5, course1);
        
        registrationService.enrollStudentInCourse(student1, course2);
        registrationService.enrollStudentInCourse(student3, course2);
        registrationService.enrollStudentInCourse(student4, course2);
        // This enrollment should fail due to capacity (course2 has capacity 3)
        registrationService.enrollStudentInCourse(student5, course2);

        // Display course details
        System.out.println("\n=== Course Details ===");
        course1.displayDetails();
        System.out.println();
        course2.displayDetails();

        // Print rosters (for backward compatibility)
        System.out.println("\n=== Course Rosters ===");
        System.out.println(course1.roster());
        System.out.println(course2.roster());

        // Show auto-generated IDs
        System.out.println("\n=== Auto-Generated IDs ===");
        System.out.println("Student IDs:");
        for (Student s : registrationService.getStudents()) {
            System.out.println(s.getStudentId() + ": " + s.getName());
        }
        System.out.println("\nCourse IDs:");
        System.out.println("Course 1: C" + course1.getCourseId() + " - " + course1.getCourseName());
        System.out.println("Course 2: C" + course2.getCourseId() + " - " + course2.getCourseName());

        // Mark attendance using object-based overload
        System.out.println("\n=== Marking Attendance ===");
        attendanceService.markAttendance(student1, course1, "Present");
        attendanceService.markAttendance(student2, course1, "Absent");
        attendanceService.markAttendance(student3, course2, "Present");
        attendanceService.markAttendance(student4, course2, "InvalidStatus"); // Test validation
        attendanceService.markAttendance(student1, course2, "absent"); // Test case-insensitive

        // Mark attendance using ID-based overload (lookup via registrationService)
        attendanceService.markAttendance(student5.getStudentId(), course1.getCourseId(), "Present");

        // Display attendance logs using overloaded display methods
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(student1);
        attendanceService.displayAttendanceLog(course2);

        // Persist all data to files
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nData saved: students.txt, teachers.txt, staff.txt, courses.txt, attendance_log.txt");
    }
}