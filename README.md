# appointment-system
REST API for managing appointments with business rules, built with Spring Boot


**Appointment System API**

This project is a REST API built with Spring Boot to manage clients and appointments.

The goal was to move beyond a basic CRUD and implement real business logic, similar to what you would find in a real scheduling system.

Features:
Client management (create, update, delete, list)
Appointment scheduling
Business rules:
Prevent duplicate appointments (same date and time)
Prevent appointments in the past
Restrict appointments to working hours (09:00 - 18:00)
Prevent cancellation of past appointments
Available time slots calculation per day
Filtering appointments by client and date
Global error handling



Tech Stack:
Java
Spring Boot
Spring Data JPA (Hibernate)
H2 Database
Maven



Endpoints:

Clients
GET /clients
GET /clients/{id}
POST /clients
PUT /clients/{id}
DELETE /clients/{id}
Appointments
GET /appointments
GET /appointments?clientId=1
GET /appointments?date=2026-04-12
POST /appointments
DELETE /appointments/{id}
Availability
GET /appointments/available?date=2026-04-12



Example request:
{
  "date": "2026-04-12",
  "time": "10:00:00",
  "clientId": 1
}




Project structure:
controller → handles HTTP requests
service → contains business logic
repository → database access
dto → request and response objects
validation → business rules
exception → global error handling


