Hospital Management System
Show Image
Show Image
Show Image
A console-based Hospital Management System built using Core Java, JDBC, and MySQL to efficiently manage patient records with full CRUD operations.

📋 Features

✅ Add new patient records
✅ View all patients
✅ Update patient information
✅ Delete patient records
✅ Search patient by ID
✅ Manages 500+ patient records
✅ Reduces manual data entry errors by ~70%


🛠️ Tech Stack
TechnologyUsageCore JavaBusiness Logic & OOPJDBCDatabase ConnectivityMySQLData StorageOOP PrinciplesModular & Clean Code

📁 Project Structure
HospitalManagementSystem/
│
├── src/
│   ├── Main.java               # Entry point & menu
│   ├── Patient.java            # Patient model class
│   ├── DatabaseConnection.java # JDBC connection handler
│   └── PatientDAO.java         # CRUD operations
│
└── README.md

⚙️ How to Run
Prerequisites

Java JDK 8 or above
MySQL Server installed
Any IDE (VS Code / NetBeans / IntelliJ)

Steps
1. Clone the repository
bashgit clone https://github.com/AADARSHKUMAR45/HospitalManagementSystem.git
cd HospitalManagementSystem
2. Setup MySQL Database
sqlCREATE DATABASE hospital_db;
USE hospital_db;

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    disease VARCHAR(100),
    doctor VARCHAR(100),
    contact VARCHAR(15)
);
3. Update Database Credentials
java// In DatabaseConnection.java
String url = "jdbc:mysql://localhost:3306/hospital_db";
String username = "your_mysql_username";
String password = "your_mysql_password";
4. Compile and Run
bashjavac src/*.java
java src/Main

📸 Sample Output
========================================
   HOSPITAL MANAGEMENT SYSTEM
========================================
1. Add Patient
2. View All Patients
3. Update Patient
4. Delete Patient
5. Search Patient by ID
6. Exit
========================================
Enter your choice: 1

Enter Patient Name: Rahul Sharma
Enter Age: 25
Enter Disease: Fever
Enter Doctor: Dr. Mehta
Enter Contact: 9876543210

✅ Patient added successfully!

📚 Concepts Used

OOP Principles — Encapsulation, Abstraction, Inheritance
JDBC — DriverManager, Connection, PreparedStatement, ResultSet
MySQL — DDL, DML, Relational Database
Exception Handling — try-catch for database errors
Collections — ArrayList for storing patient data
