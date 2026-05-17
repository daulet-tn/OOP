# User Role Management System

## Project Description

This project is a console-based university management system developed in Java using Object-Oriented Programming principles. The system helps students, teachers, managers, administrators, and research employees work together inside the university environment.

The project includes basic university functions such as course registration, viewing marks and transcript, sending messages, publishing news, approving requests, generating reports, and managing research activities.

The main goal of the project is to demonstrate the use of inheritance, polymorphism, abstraction, encapsulation, interfaces, exceptions, serialization, and design patterns in a real Java application.

---

## Main Features

### Student

* Register for courses
* View marks
* Get transcript
* Rate teachers
* Send messages
* View inbox

### Teacher

* Manage courses
* Put marks
* View students
* Receive ratings

### Manager

* Approve or reject registration requests
* Assign teachers to courses
* Publish news
* Generate academic reports

### Admin

* Add users
* Remove users
* Update users
* View logs
* View all users

### Research Employee

* Add research papers
* Add research projects
* Calculate H-index
* Start research projects

---

## OOP Principles Used

* Inheritance
* Polymorphism
* Abstraction
* Encapsulation
* Interfaces

---

## Design Patterns

### Singleton

Used in:

* Database
* Logger
* UserFactory

### Factory

Used in:

* UserFactory

### Observer

Used for:

* News publishing and notification system

---

## Project Structure

### users

Contains all user classes:

* User
* Student
* Teacher
* Manager
* Admin
* Employee
* ResearchEmployee

### academic

Contains academic classes:

* Course
* Lesson
* Mark
* Transcript
* ResearchPaper
* ResearchProject

### communication

Contains communication classes:

* Message
* Request
* Complaint
* News

### system

Contains system classes:

* Database
* Logger
* UserFactory

### interfaces

Contains interfaces:

* Observer
* Observable
* Printable
* Researcher

### enums

Contains enumerations:

* UserRole
* TeacherTitle
* StudentDegree
* ManagerType
* LessonType
* RequestStatus

### exceptions

Contains custom exceptions:

* MaxCreditsExceededException
* LowHIndexException
* NotAResearcherException
* MaxFailsExceededException

---

## Technologies Used

* Java
* VS Code
* PlantUML / UML Diagrams
* GitHub

---

## UML Diagrams

The project includes:

1. Use-Case Diagram
2. Object Diagram
3. Class Diagram Before Refactoring
4. Class Diagram After Refactoring

---

## Team Members

* Tanirberdi Daulet
* Khandilda Nurasyl
