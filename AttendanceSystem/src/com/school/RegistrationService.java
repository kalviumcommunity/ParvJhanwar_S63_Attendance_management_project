package com.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages registration of students, teachers, staff, and courses.
 * Depends on FileStorageService to persist data.
 */
public class RegistrationService {
    private final List<Student> students;
    private final List<Teacher> teachers;
    private final List<Staff> staffMembers;
    private final List<Course> courses;
    private final FileStorageService fileStorageService;

    /**
     * Constructor with dependency injection of FileStorageService.
     * @param fileStorageService the file storage service for persisting data
     */
    public RegistrationService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    /**
     * Register a new student.
     * @param student the student to register
     */
    public void registerStudent(Student student) {
        students.add(student);
    }

    /**
     * Register a new teacher.
     * @param teacher the teacher to register
     */
    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Register a new staff member.
     * @param staff the staff member to register
     */
    public void registerStaff(Staff staff) {
        staffMembers.add(staff);
    }

    /**
     * Create and register a new course.
     * @param course the course to create
     */
    public void createCourse(Course course) {
        courses.add(course);
    }

    /**
     * Get all registered students.
     * @return list of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Get all registered teachers.
     * @return list of teachers
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Get all registered staff members.
     * @return list of staff members
     */
    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    /**
     * Get all registered courses.
     * @return list of courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Find a student by their ID.
     * @param id the student ID to search for
     * @return the student if found, null otherwise
     */
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Find a course by its ID.
     * @param id the course ID to search for
     * @return the course if found, null otherwise
     */
    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    /**
     * Get all people (students, teachers, and staff) as a combined list.
     * @return list of all Person objects
     */
    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    /**
     * Save all registered data to their respective files.
     */
    public void saveAllRegistrations() {
        fileStorageService.saveData(students, "students.txt");
        fileStorageService.saveData(teachers, "teachers.txt");
        fileStorageService.saveData(staffMembers, "staff.txt");
        fileStorageService.saveData(courses, "courses.txt");
    }
}
