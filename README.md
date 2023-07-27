# New User Email Notification

This is a Java application that sends an email notification to new registered user. This small project demonstrate how to use JavaMail to send an email and how to load email credentials form a .env file for added security.

## Getting Started
Follow these instructions to set up and run the this project on your local machine.

## Prerequisites
* Java Development Kit (JDK) installed on your machine.
* A text editor or an Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or NetBeans, But I like IntelliJ IDEA most.

## Installation
1. Open a Terminal and run the following commands.
```terminal
mkdir javamail
cd javamail
git clone https://github.com/hemantDwivedi/java-mail-api.git
```
Or you can download and extract ```ZIP``` file.

2. Create a .env file in the root directory of the project and add the following lines to it:
```file
SENDER_EMAIL=your_email@example.com
SENDER_PASSWORD=your_email_password
```

Replace your_email@example.com with your actual sender email and your_email_password with your actual sender email password.

## Usage

1. Open a terminal or command prompt and navigate to the root directory of the project.

2. Compile the Java classes using the following command:

```terminal
javac -cp lib/javax.mail.jar:lib/activation.jar src/main/java/com/email/Main.java
```

3. Run the application using the following command:
```terminal
java -cp .:lib/javax.mail.jar:lib/activation.jar src/main/java/com/email/Main
```

4. The application will prompt you to enter a new user's name and email. It will then send an email to the provided email address, simulating an email notification for a newly created user.

## Things to remember
* Please keep the .env file secure and do not share it publicly or include it in version control systems.

* This project is for demonstration purposes and lacks proper error handling and security features. In a production environment, use environment variables or other secure methods to manage sensitive configuration.

## Acknowledgments
- The JavaMail API and JavaBeans Activation Framework for enabling email functionality.