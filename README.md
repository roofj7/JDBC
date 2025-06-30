# Student Database Management System (Java + JDBC + Oracle SQL)
This is a simple console-based Java project that allows users to manage student records using JDBC and Oracle 11g XE. It supports basic operations like adding, viewing, searching, and deleting student details from a database table.

# Features:
- Add a student (roll number, name, CGPA)
- Display all student records
- Search for a student by roll number
- Delete a student record
- Console-based menu system

# Technologies Used:
- Java
- JDBC
- Oracle 11g XE

# How to Run:
Make sure Oracle XE is installed and running.
Create the database table:

CREATE TABLE student1 (
rno INT PRIMARY KEY,
name VARCHAR2(50),
cgpa FLOAT
);

# Compile and run the program using:
javac -cp .;ojdbc8.jar Test02.java
java -cp .;ojdbc8.jar Test02

<details> <summary>Click to expand</summary>
Connected to the database

1. Add Student
2. Display All
3. Search
4. Delete
5. Exit
Enter your choice: 1
Enter rno, name and cgpa: 34 Sid 6.8
Student added successfully.

1. Add Student
2. Display All
3. Search
4. Delete
5. Exit
Enter your choice: 2
34 - Sid - 6.8
32 - Ramesh - 8.0
33 - Suresh - 7.5

1. Add Student
2. Display All
3. Search
4. Delete
5. Exit
Enter your choice: 3
Enter rno to search: 33
33 - Suresh - 7.5

1. Add Student
2. Display All
3. Search
4. Delete
5. Exit
Enter your choice: 4
Enter rno to delete: 34
34 - Deleted successfully...

1. Add Student
2. Display All
3. Search
4. Delete
5. Exit
Enter your choice: 5
Thank you
</details>
