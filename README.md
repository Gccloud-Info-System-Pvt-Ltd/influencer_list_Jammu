# Form App (Spring Boot)

A simple Spring Boot application with a form that saves submissions to a database.

## Fields
Name, Phone, Email, Instagram, Description, District, Extra One, Extra Two, Extra Three.

## Requirements
- Java 17 or higher
- Maven

## Run
```bash
mvn spring-boot:run
```

Then open:
- Form:        http://localhost:8080/
- Submissions: http://localhost:8080/submissions
- H2 console:  http://localhost:8080/h2-console
  (JDBC URL: `jdbc:h2:file:./data/formdb`, user: `sa`, no password)

## Build a runnable JAR
```bash
mvn clean package
java -jar target/form-app-1.0.0.jar
```

## Database
By default uses **H2 file-based** storage (saved in `./data/formdb`) so data persists
across restarts and no setup is needed.

To switch to **MySQL**, open `src/main/resources/application.properties`,
comment out the H2 block, and uncomment the MySQL block (set your username/password).

## Project structure
```
form-app/
├── pom.xml
└── src/main/
    ├── java/com/example/formapp/
    │   ├── FormAppApplication.java
    │   ├── model/Submission.java
    │   ├── repository/SubmissionRepository.java
    │   └── controller/FormController.java
    └── resources/
        ├── application.properties
        └── templates/
            ├── form.html
            └── submissions.html
```
