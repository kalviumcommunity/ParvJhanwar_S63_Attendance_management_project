package com.school;

/**
 * Represents a course holding a fixed-size roster of students.
 */
public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private final int courseId;
    private final String courseName;
    private final Student[] students; // simple fixed-size roster for Part 2
    private int count = 0;

    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
        this.students = new Student[capacity];
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public Student[] getStudents() { return students; }
    public int getCount() { return count; }

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
        // Format: courseId,courseName
        return courseId + "," + courseName;
    }
}