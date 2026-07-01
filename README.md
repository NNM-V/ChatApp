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
1.About the Project

2.Environment

3.Directory

4.How to Build

5.How to Use

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
```

## How to Bulid
1.Clone the repository to your local enviroment.

2.Move to directory that contains the app.

3.Creat MySQLDatabase on your local enviroment.

4.Open "applications.properties" file and change datasource setting based on your local enviroment.

5.Uncomment "#spring.sql.init.mode=always" in "applications.properties" for initial build.

6.Run the program with maven.
```bash
./mvnw spring-boot:run
```

7.Commentout"#spring.sql.init.mode=always" from process 5.

## How to Use
1. Open the application in two different browsers.

2.Use the Login information created "data.sql" and login to the application.
The Password for both "Admin" and "User" is "Password#".

3.Type in the user you want to communicate in searchbox of "mypage".

4.Press Talk button to start the chat.

5.You can also use the  Login page to register a new account.
