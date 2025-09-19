package com.school;

/**
 * Represents a student with basic attendance tracking.
 */
public class Student {
    private static int nextStudentIdCounter = 1;
    private final int studentId;
    private final String name;
    private final int[] attendance; // 1 for present, 0 for absent, -1 for not marked

    /**
     * Create a student with an attendance array for given number of sessions.
     */
    /**
     * Create a student with a name and attendance array for given number of sessions.
     */
    public Student(String name, int sessions) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;
        this.attendance = new int[sessions];
        for (int i = 0; i < sessions; i++) {
            attendance[i] = -1; // not marked
        }
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public int[] getAttendance() { return attendance; }

    /**
     * Mark attendance for a given session index.
     * @param sessionIndex zero-based index
     * @param present true if present, false if absent
     */
    public void markAttendance(int sessionIndex, boolean present) {
        if (sessionIndex < 0 || sessionIndex >= attendance.length) {
            throw new IndexOutOfBoundsException("Invalid session index: " + sessionIndex);
        }
        attendance[sessionIndex] = present ? 1 : 0;
    }

    /**
     * Calculates percentage of sessions marked present out of sessions that have been marked.
     */
    public double getAttendancePercentage() {
        int marked = 0;
        int present = 0;
        for (int a : attendance) {
            if (a != -1) {
                marked++;
                if (a == 1) present++;
            }
        }
        if (marked == 0) return 0.0;
        return (present * 100.0) / marked;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", attendance%=" + String.format("%.1f", getAttendancePercentage()) +
                '}';
    }
}