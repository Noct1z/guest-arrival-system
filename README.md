# Guest Arrival System

## Overview
The Guest Arrival System is a Java-based backend application that simulates a guest check-in management system using PostgreSQL.  
It demonstrates relational database design, foreign key relationships, and DAO architecture implementation.

This project was built to practice backend development concepts including database modeling, JDBC integration, and object-oriented design.

---

## Technologies Used
- Java 21
- PostgreSQL
- JDBC
- Maven
- Git

---

## Database Design

The system contains two main tables:

### Guests
- guest_id (Primary Key)
- first_name
- last_name
- email (Unique)
- created_at

### Arrivals
- arrival_id (Primary Key)
- guest_id (Foreign Key → guests)
- scheduled_time
- actual_time
- status (CHECK constraint: On-Time, Delayed, Pending)
- created_at

The database enforces:
- Foreign Key constraints
- UNIQUE constraints
- CHECK constraints
- CASCADE delete behavior

---

## Features Implemented

- Insert guest with auto-generated ID
- Prevent duplicate guests using email validation
- Insert arrival linked to guest
- JOIN query to display arrivals with guest names
- DAO pattern implementation
- Clean separation of concerns
- Safe database connection handling

---

## Concepts Practiced

- Relational database modeling
- Primary and Foreign Keys
- JOIN queries
- PreparedStatement usage
- ResultSet mapping
- DAO architecture
- Handling generated keys
- Git version control best practices

---

## How to Run

1. Clone the repository
2. Configure PostgreSQL database
3. Update database credentials in `DatabaseConnection.java`
4. Run the project using Maven:
