Spring Boot Online Banking System
About
This is a robust Digital Banking Application built for practicing secure financial transactions using Spring Boot. It features a modern banking interface where users can manage accounts, view balances, and perform transactional transfers.

Tech Stack:

Backend: Spring Boot, Spring Security (Role-based access)

Frontend: Thymeleaf, Bootstrap

Data: Spring Data JPA, H2 In-Memory Database

DevOps: Docker, Maven

Features
User Authentication: Secure Login/Registration for customers and bank staff.

Account Management: Automatic creation of Savings/Current accounts upon registration.

Transaction Engine: ACID-compliant fund transfers between accounts.

Security: Protection against CSRF and unauthorized access to account data.

Configuration
The core settings are located in src/main/resources/application.properties.

Server Port: Defaulted to 8070.

Admin Credentials: Configurable via properties for bank teller/manager access.

How to Run
Using Maven
Bash

$ mvn spring-boot:run
Using Docker
Bash

$ docker build -t bank-app:latest -f docker/Dockerfile .
$ docker run -p 8070:8070 bank-app:latest
Once started, access the portal at: http://localhost:8070/home

Default Credentials:

Customer: user / password

Manager: admin / admin
