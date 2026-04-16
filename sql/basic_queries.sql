-- Basic SQL Queries Practice

-- Create Table
CREATE TABLE Students (
    id INT,
    name VARCHAR(50),
    marks INT
);

-- Insert Data
INSERT INTO Students VALUES (1, 'Ayush', 85);
INSERT INTO Students VALUES (2, 'Rahul', 78);
INSERT INTO Students VALUES (3, 'Sneha', 92);

-- Select All
SELECT * FROM Students;

-- WHERE Clause
SELECT * FROM Students WHERE marks > 80;

-- Aggregate Function
SELECT AVG(marks) AS AverageMarks FROM Students;

-- ORDER BY
SELECT * FROM Students ORDER BY marks DESC;

-- JOIN Example
CREATE TABLE Courses (
    course_id INT,
    course_name VARCHAR(50),
    student_id INT
);

SELECT Students.name, Courses.course_name
FROM Students
JOIN Courses ON Students.id = Courses.student_id;
