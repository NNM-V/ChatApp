<div id="top"></div>

<!-- Shields -->
<p style="display: inline">
	<img alt="Static Badge" src="https://img.shields.io/badge/HTML-black">
	<img alt="Static Badge" src="https://img.shields.io/badge/CSS-black">
	<img alt="Static Badge" src="https://img.shields.io/badge/Java-blue">
	<img alt="Static Badge" src="https://img.shields.io/badge/SpringBoot-green">
	<img alt="Static Badge" src="https://img.shields.io/badge/SpringSecurity-green">
	<img alt="Static Badge" src="https://img.shields.io/badge/WebSocket-green">
</p>

# Private chat application

## Table of Contents
- About the Project
- Environment
- Directory
- How to Build
- How to Use

## About the Project
Secured one on one private chat web application with SpringSecurity and WebSocket.

## Enviroment
- Java 21
- Spring Boot 4.0.6
- Spring Security
- Spring Data JPA
- WebSocket (STOMP)
- Thymeleaf
- MySQL
- Lombok


## Directory
```text
.
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── java
        └── resources
```

## How to Build
1.Clone the repository to your local environment.
```bash
git clone https://github.com/NNM-V/ChatApp.git
```
2.Open a terminal and create a MySQL database to store the user data on your local environment.

2.Move to directory that contains the application on the terminal.

3.Open "application.properties" file from under the directory below and change datasource settings based on database you created on step 2.
```bash
ChatApp/src/main/resources
```

5.Uncomment "#spring.sql.init.mode=always" in "applications.properties" for initial build.

6.Return to the ChatApp root directory and run the program with maven.
```bash
./mvnw spring-boot:run
```

7.Comment out "#spring.sql.init.mode=always" again after completing step 5.

## How to Use
1.Open the application in two different browsers.

2.Login to the application using user account created under "users" table in your local database. The Password for both "Admin" and "User" is "Password#".

3.Enter the username of the person you want to communicate in searchbox on "mypage".

4.Press "Talk" button to start the chat.

5.You can also use the "login" page to register a new account.
