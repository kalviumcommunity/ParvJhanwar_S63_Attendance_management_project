package com.school;

/**
 * Base class for all persons in the school system.
 */
public class Person {
    private static int nextIdCounter = 1;
    protected int id;
    protected String name;

    /**
     * Constructor that auto-increments ID and assigns name.
     * @param name the name of the person
     */
    public Person(String name) {
        this.id = nextIdCounter++;
        this.name = name;
    }

    /**
     * Get the ID of the person.
     * @return the person's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Get the name of the person.
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Display details of the person.
     */
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}
