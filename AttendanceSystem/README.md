# Attendance Management System

## Project Overview
A simple Java-based project for learning purposes.

## How to Compile and Run (Part 1)
- Navigate to project root.
- Compile:
  ```bash
  javac AttendanceSystem/src/com/school/Main.java
  ```
- Run:
  ```bash
  java -cp AttendanceSystem/src com.school.Main
  ```

## Part 2 Updates
- **New classes**: `Student.java`, `Course.java` in `AttendanceSystem/src/com/school/`.
- **Main.java** now demonstrates arrays of `Student` and `Course`, enrollment, and simple attendance marking.

### Compile (Part 2)
```bash
javac AttendanceSystem/src/com/school/Student.java \
      AttendanceSystem/src/com/school/Course.java \
      AttendanceSystem/src/com/school/Main.java
```

### Run
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Expected Output (example)
```
Welcome to Attendance Management System!

Course Rosters:
CS101 - Intro to CS (3/ 5)
  1. Student{id=1, name='Alice', attendance%=100.0}
  2. Student{id=2, name='Bob', attendance%=0.0}
  3. Student{id=3, name='Charlie', attendance%=100.0}

MATH201 - Discrete Math (2/ 5)
  1. Student{id=1, name='Alice', attendance%=100.0}
  2. Student{id=3, name='Charlie', attendance%=100.0}
```