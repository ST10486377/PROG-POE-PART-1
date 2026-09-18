# PROG-POE-PART-1
# Chat App - Part 1: Registration and Login

Student: Njabulo Ndlovu
Student Number: ST10486377

## Project description

This is a Java Maven console application implementing Part 1 of the Chat App POE.

The application demonstrates:
- Variables and variable scope
- Data types
- Classes and methods
- OOP principles
- Decisions
- Regular expressions
- Input and output
- Unit testing with JUnit 5
- Maven test execution

No GUI components or JOptionPane are used.

## Requirements

- JDK 17 or later
- Apache Maven
- NetBeans, IntelliJ IDEA, VS Code, or another Java IDE
- Git and GitHub

## Running the application

From the project root:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="za.ac.cput.Main"
```

If the IDE does not have the Maven exec plugin configured, simply run `Main.java` from the IDE.

## Running unit tests

```bash
mvn clean test
```

All tests are located in:

`src/test/java/za/ac/cput/LoginTest.java`

## Validation rules

### Username
A valid username:
- contains an underscore `_`
- is no more than five characters long

Example:

`kyl_1`

### Password
A valid password:
- contains at least eight characters
- contains a capital letter
- contains a number
- contains a special character

Example:

`Ch&&sec@ke99!`

### Cell phone
The application accepts a South African mobile number in international format.

Example:

`+27838968976`

Regex reference included in `Login.java`:

Baeldung, "A Guide to Regular Expressions in Java",
https://www.baeldung.com/regular-expressions-java
