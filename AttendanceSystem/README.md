# Attendance Management System

## Project Overview
A simple Java-based project for learning purposes.

## Part 3 Updates

- **Auto-generated IDs**: Student and Course objects now use constructors with static counters for unique IDs.
- **Student**: Use `Student(String name, int sessions)` constructor. IDs are assigned automatically.
- **Course**: Use `Course(String courseName, int capacity)` constructor. Course IDs are assigned automatically and displayed as `C101`, `C102`, etc.
- **Main.java**: Demonstrates creation of multiple students/courses and shows auto-generated IDs in output.

### How to Compile (Part 3)
```bash
javac AttendanceSystem/src/com/school/Student.java AttendanceSystem/src/com/school/Course.java AttendanceSystem/src/com/school/Main.java
```

### How to Run
```bash
java -cp AttendanceSystem/src com.school.Main
```

### Expected Output (example)
```
Welcome to Attendance Management System!

Course Rosters:
C101 - Intro to CS (5/ 5)
  1. Student{studentId=1, name='Alice', attendance%=100.0}
  2. Student{studentId=2, name='Bob', attendance%=0.0}
  3. Student{studentId=3, name='Charlie', attendance%=100.0}
  4. Student{studentId=4, name='David', attendance%=0.0}
  5. Student{studentId=5, name='Eva', attendance%=0.0}

C102 - Discrete Math (3/ 5)
  1. Student{studentId=1, name='Alice', attendance%=100.0}
  2. Student{studentId=3, name='Charlie', attendance%=100.0}
  3. Student{studentId=4, name='David', attendance%=0.0}

Student IDs:
1: Alice
2: Bob
3: Charlie
4: David
5: Eva

Course IDs:
Course 1: C101 - Intro to CS
Course 2: C102 - Discrete Math
```