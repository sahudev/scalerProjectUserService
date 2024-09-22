# User Service - E-commerce Microservice

Note: Please ref all these repos for the complete project 
https://github.com/sahudev/scalerProjectUserService; 
https://github.com/sahudev/scalerProjectPaymentService; 
https://github.com/sahudev/scalerProjectProductService; 
https://github.com/sahudev/scalerProjectEmailService;

## Overview
This repository contains the **User Service** for an e-commerce application, developed as part of a microservices-based architecture. The User Service handles all user-related operations such as registration, authentication, and managing user profiles.

Built with **Spring Boot**, this service is designed to handle user data securely, integrating smoothly with other microservices such as the Product and Payment Services.

## Features
- User registration with unique email and password.
- User authentication and login, with session management.
- User profile management (update profile details, view profile).
- Role-based access control (e.g., admin vs customer roles).
- Password hashing for secure storage.
  
## Technologies Used
- **Java 11**: Core language for the backend services.
- **Spring Boot**: Framework for building microservices.
- **Spring Security**: For managing authentication and authorization.
- **Spring Data JPA**: To interact with the database using ORM (Object-Relational Mapping).
- **MySQL**: Database used for storing user information.
- **JWT (JSON Web Token)**: Used for stateless authentication.
- **Docker**: For containerization and deployment.
- **AWS RDS**: Relational database service hosted on AWS.

## Project Structure
This service is structured in line with **Spring Boot's MVC architecture**, featuring:
- **Controller**: Handles incoming HTTP requests (like login, registration) and passes them to the service layer.
- **Service**: Contains the business logic for user operations (e.g., creating new users, logging in).
- **Repository**: Interacts with the database to persist user data securely.
- **Model**: Represents the `User` entity and its relationship with roles and permissions.

## API Endpoints

### User Management Endpoints:
1. **User Registration**
   - `POST /users/register`
   - Registers a new user with an email, password, and role.

2. **User Login**
   - `POST /users/login`
   - Authenticates a user using email and password, generates a JWT token for secure session management.

3. **Get User Profile**
   - `GET /users/{id}`
   - Retrieves profile information for a specific user by their ID.

4. **Update User Profile**
   - `PUT /users/{id}`
   - Allows a user to update their profile details (name, email, etc.).

5. **Delete User Account**
   - `DELETE /users/{id}`
   - Allows a user or admin to delete a user account.

## Installation

### Prerequisites:
- **Java 11** or higher
- **Maven** for dependency management
- **MySQL** for the database (local or hosted)
- **Docker** (optional) for containerized deployment

### Steps to Set Up Locally:
1. **Clone the repository**:
   ```bash
   git clone https://github.com/sahudev/scalerProjectUserService
   ```

2. **Configure the Database**:
   - Update the `application.properties` file with your MySQL database connection details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/users_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. **Run the Application**:
   Navigate to the root folder and run:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**:
   Once the application is running, you can use a tool like **Postman** or **curl** to interact with the APIs:
   - Example to register a new user:
     ```bash
     curl -X POST http://localhost:8080/users/register -H "Content-Type: application/json" -d '{"email":"test@example.com", "password":"password123"}'
     ```

### Docker Deployment:
You can containerize the application using Docker:
1. Build the Docker image:
   ```bash
   docker build -t user-service .
   ```

2. Run the container:
   ```bash
   docker run -p 8080:8080 user-service
   ```

## AWS Deployment
The service can be deployed on **AWS** using **EC2** instances or **AWS Elastic Beanstalk** for simplified infrastructure management. AWS **RDS** is recommended for the database layer to provide high availability and scalability. Use **AWS IAM** and **Security Groups** to ensure secure access and proper role-based access control.

## Security
- **Spring Security** and **JWT**: The service uses Spring Security to handle authentication and authorization. JSON Web Tokens (JWT) are used for stateless session management, allowing users to securely interact with the service without maintaining server-side session data.
- **Password Hashing**: User passwords are hashed using **BCrypt**, ensuring secure storage in the database.

## Contribution
Contributions are welcomed! Please feel free to submit issues or pull requests to improve the project or add new features.
