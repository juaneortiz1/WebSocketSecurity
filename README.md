
# Interactive Drawing App with WebSockets and ReactJS

## Overview

This application demonstrates real-time bidirectional communication between clients and a server using WebSockets. Clients can initiate drawing actions, and each client's strokes are differentiated from those of remote clients. This project uses Spring Boot for the backend server and ReactJS for the frontend interface.

## Features

- **Real-time Drawing:** Multiple clients can draw simultaneously with immediate updates visible to all connected clients.
- **Unique Client Strokes:** Each client's drawing actions are distinguishable through different stroke styles or colors.
- **Responsive UI:** The ReactJS frontend provides an intuitive and responsive interface for drawing and viewing.
- **Secure Authentication:** User authentication is managed using Spring Security and MongoDB.

## Technologies Used

- **Backend:** Spring Boot, WebSocket API, Spring Security
- **Frontend:** ReactJS, WebSocket client
- **Database:** MongoDB (for user authentication)
- **Communication Protocol:** WebSocket for real-time bidirectional communication
- **Build Tools:** Maven (for backend), npm (for frontend dependencies)

## Screenshots

![image](https://github.com/juaneortiz1/InteractiveBoardWS/assets/97971732/162254a4-8354-4cf8-b106-440f8ca2d34f)
![image](https://github.com/juaneortiz1/InteractiveBoardWS/assets/97971732/b1b81589-855f-420f-b9dc-865927884a14)

## Architecture

The architecture of the application involves three main components:

1. **Backend (Spring Boot):**
    - Uses WebSocket API for handling real-time communication between clients.
    - Manages client connections, broadcasts drawing updates to all connected clients.
    - Implements Spring Security for user authentication and authorization.
    - Utilizes MongoDB to store user credentials and authentication data.

2. **Frontend (ReactJS):**
    - Provides a user-friendly interface for drawing.
    - Establishes a WebSocket connection to the backend server for real-time updates.
    - Differentiates between local and remote drawing actions to maintain a consistent and responsive user experience.

3. **Database (MongoDB):**
    - Stores user information for authentication and authorization purposes.
![image](https://github.com/user-attachments/assets/7f0e3c34-12f0-4a8a-bf78-24178511273b)


### Architecture Diagram

![Diagrama en blanco](https://github.com/juaneortiz1/InteractiveBoardWS/assets/97971732/bdc5bcc4-abc7-4936-9c42-2a48be5cc1e3)

This project leverages ReactJS on the client-side and Spring.io on the server-side to create a real-time collaborative drawing application. Clients interact through a dynamic user interface powered by ReactJS, while P5.js manages the interactive drawing canvas. Spring.io manages WebSocket connections, facilitating seamless bidirectional communication between clients and enabling real-time updates of drawings. AWS provides scalable hosting and storage solutions, ensuring the application remains responsive and reliable even with multiple simultaneous users. Together, these technologies form a robust architecture that allows users to collaboratively draw, with distinct visualization of their own and others' contributions, enhancing the interactive and collaborative experience.

## Deployment

This application has been deployed on Amazon Web Services (AWS) and is accessible at:

[http://ec2-54-90-71-142.compute-1.amazonaws.com:8080/](http://ec2-54-90-71-142.compute-1.amazonaws.com:8080/)

## Getting Started

To run this application locally, follow these steps:

1. **Clone the repository:**
   ```
   git clone https://github.com/juaneortiz1/InteractiveBoardWS.git
   cd repository-folder
   ```

2. **Backend Setup:**
    - Navigate to the `backend` directory.
    - Build the project using Maven:
      ```
      mvn clean package
      ```
    - Run the Spring Boot application:
      ```
      java -jar target/backend.jar
      ```

3. **Frontend Setup:**
    - Navigate to the `frontend` directory.
    - Install dependencies using npm:
      ```
      npm install
      ```
    - Start the React application:
      ```
      npm start
      ```

4. **Accessing the Application:**
    - Open a web browser and go to `http://localhost:8080` to view and interact with the drawing application.

## Dependencies

Ensure the following dependencies are included in your `pom.xml` file for Spring Security and MongoDB integration:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
	<groupId>org.thymeleaf.extras</groupId>
	<artifactId>thymeleaf-extras-springsecurity6</artifactId>
	<!-- Temporary explicit version to fix Thymeleaf bug -->
	<version>3.1.1.RELEASE</version>
</dependency>
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-test</artifactId>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>


---

This README now includes the information about Spring Security for web security and MongoDB for user authentication. Let me know if you need any further modifications!

