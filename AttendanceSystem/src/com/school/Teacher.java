package com.school;

/**
 * Represents a teacher in the school system.
 */
public class Teacher extends Person implements Storable {
    private String subjectTaught;

    /**
     * Constructor that calls super and sets the subject taught.
     * @param name the name of the teacher
     * @param subjectTaught the subject this teacher teaches
     */
    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    /**
     * Get the subject taught by this teacher.
     * @return the subject taught
     */
    public String getSubjectTaught() {
        return subjectTaught;
    }

    /**
     * Set the subject taught by this teacher.
     * @param subjectTaught the subject to teach
     */
    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher, Subject: " + subjectTaught);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subjectTaught + '\'' +
                '}';
    }

    @Override
    public String toDataString() {
        // Format: id,name,subjectTaught
        return id + "," + name + "," + subjectTaught;
    }
}
