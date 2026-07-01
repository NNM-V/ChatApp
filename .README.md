<div id="top"></div>

<!-- Sheilds -->
<p style="display: inline">
	<img alt="Static Badge" src="https://img.shields.io/badge/HTML-black">
	<img alt="Static Badge" src="https://img.shields.io/badge/CSS-black">
	<img alt="Static Badge" src="https://img.shields.io/badge/Java-blue">
	<img alt="Static Badge" src="https://img.shields.io/badge/SpringBoot-green">
	<img alt="Static Badge" src="https://img.shields.io/badge/SpringSecurity-green">
	<img alt="Static Badge" src="https://img.shields.io/badge/WebSocker-green">
</p>

##Index
1.About the project
2.Enviroment
3.Directory
4.How to Build
5.How to Use

##Project Name
Private chat application

##About the Project

Secured 1 on 1 chat application

##Enviroment

- Java 21
- Spring Boot 4.0.6
- Spring Security
- Spring Data JPA
- WebSocket (STOMP)
- Thymeleaf
- MySQL
- Lombok


##Directory

.
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   └── test
└── target
    ├── classes
    ├── generated-sources
    ├── generated-test-sources
    ├── maven-status
    ├── spring-aot
    └── test-classes

##How to Bulid
1.Clone the repository to your local enviroment.

2.Move to directory that contains the app.

3.Creat MySQLDatabase on your local enviroment.

4.Open "applications.properties" file and change datasource setting based on your local enviroment.

5.Take commentout off from "#spring.sql.init.mode=always" in "applications.properties" for initial build.

6.Run the program with maven.
```bash
./mvnw spring-boot:run
```

7.Commentout the command from process 5.

##How to Use
1. Open two different Browser application.

2.Use the Login information created from data.sql and login to the application.
The Password for both "Admin" and "User" is "Password#".

3.Type in the user you want to communicate in searchbox of "mypage".

4.Press Talk button and start the chat.

5.Use Login page to sign up a new user.
