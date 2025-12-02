package com.school;

/**
 * Represents a staff member in the school system.
 */
public class Staff extends Person implements Storable {
    private String staffRole;

    /**
     * Constructor that calls super and sets the staff role.
     * @param name the name of the staff member
     * @param staffRole the role of this staff member (e.g., "Administrator", "Maintenance")
     */
    public Staff(String name, String staffRole) {
        super(name);
        this.staffRole = staffRole;
    }

    /**
     * Get the role of this staff member.
     * @return the staff role
     */
    public String getStaffRole() {
        return staffRole;
    }

    /**
     * Set the role of this staff member.
     * @param staffRole the role to set
     */
    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Staff, Staff Role: " + staffRole);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", staffRole='" + staffRole + '\'' +
                '}';
    }

    @Override
    public String toDataString() {
        // Format: id,name,staffRole
        return id + "," + name + "," + staffRole;
    }
}
