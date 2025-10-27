# Attendance Management System

## Project Overview
A simple Java-based project for learning purposes.

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to `Student` and `Course` classes by making fields `private` and adding public `getters`.
- Introduced a new `AttendanceRecord` class with `private` fields, a constructor, and `getters` to store attendance data.
- Implemented basic validation in the `AttendanceRecord` constructor for the attendance status (allowing only "Present" or "Absent").
- Used an `ArrayList` in `Main.java` to store and display `AttendanceRecord` objects.
- Demonstrated retrieving IDs using getters (e.g., `student1.getStudentId()`) when creating records.

## Part 5: Inheritance Hierarchy
- Created a `Person` base class with:
  - `private static int nextIdCounter` for auto-incrementing IDs
  - `protected int id` and `protected String name` accessible to subclasses
  - Constructor that auto-increments ID
  - `getId()` and `getName()` getters
  - `displayDetails()` method
- Refactored `Student` class to extend `Person`:
  - Removed manual ID counter logic
  - Added `gradeLevel` field
  - Overrode `displayDetails()` to call `super.displayDetails()` and print grade level and role
- Created `Teacher` class extending `Person`:
  - Added `subjectTaught` field
  - Overrode `displayDetails()` to show subject and role
- Created `Staff` class extending `Person`:
  - Added `staffRole` field
  - Overrode `displayDetails()` to show staff role
- Demonstrated polymorphism in `Main.java` by:
  - Creating instances of Student, Teacher, and Staff
  - Using Person array references to call overridden methods
  - Showing how different subclasses override the `displayDetails()` method

### How to Run (Part 5)
1. Navigate to the project root directory (AttendanceSystem folder).
2. Compile all files:
   ```bash
   javac src/com/school/Person.java src/com/school/Student.java src/com/school/Teacher.java src/com/school/Staff.java src/com/school/Course.java src/com/school/AttendanceRecord.java src/com/school/Main.java
   ```
3. Run:
   ```bash
   java -cp src com.school.Main
   ```

### Key Features (Part 5)
- **Inheritance**: Person base class with Student, Teacher, and Staff subclasses
- **Polymorphism**: Different displayDetails() implementations for each type
- **Protected Members**: Subclasses access inherited `id` and `name` through protected modifiers
- **Auto-ID Generation**: All Person subclasses share the same ID counter
- **Method Overriding**: Each subclass customizes displayDetails() with super() call