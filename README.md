# Expense Tracker

A simple expense tracking application built using **Spring Boot** and **MySQL**. This application allows users to record, manage, and analyze their expenses efficiently.

## Features

- **User Authentication:** Secure login and registration system.
- **Add Expenses:** Log expenses with categories, descriptions, and amounts.
- **Expense Categories:** Predefined and custom categories for better organization.
- **View & Edit Expenses:** Users can view, update, and delete their expenses.
- **Monthly Reports:** Generate reports and summaries of expenses.
- **REST API:** Exposes endpoints for integration with frontend or mobile applications.

## Technologies Used

- **Backend:** Spring Boot (Spring MVC, Spring Data JPA, Spring Security)
- **Database:** MySQL
- **Frontend (Optional):** React, Angular, or Java Swing/JavaFX
- **API Documentation:** Swagger

## Prerequisites

- Java 17 or later
- MySQL Server
- Maven or Gradle
- Postman (optional, for testing APIs)

## Installation and Setup

### 1. Clone the Repository

```sh
git clone https://github.com/yourusername/expense-tracker.git
cd expense-tracker 
```
### 2.Configure Application Properties
Create or update src/main/resources/application.properties:
```sh
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/ExpenseTracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

### 3. Build and Run the Application
Using Maven
```sh
mvn clean install
mvn spring-boot:run
```

Using Gradel
```sh
./gradlew build
./gradlew bootRun
```

### 4.API Documentation
Once the application is running, open:

```sh 
http://localhost:8080/swagger-ui.html
```





