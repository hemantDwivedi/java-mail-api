package main.java.com.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        try {
            InputStream inputStream = new FileInputStream(".env");
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }

        String senderEmail = properties.getProperty("SENDER_EMAIL");
        String senderPassword = properties.getProperty("SENDER_PASSWORD");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new user's name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter new user's email: ");
        String userEmail = scanner.nextLine();

        User newUser = new User(userName, userEmail);

        try {
            sendNewUserEmail(newUser, session, senderEmail);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static void sendNewUserEmail(User newUser, Session session, String senderEmail) throws MessagingException {
        String recipientEmail = newUser.getEmail();
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject("Welcome to our application!");
        message.setText("Dear " + newUser.getName() + ",\n\n" +
                "Welcome to our application! We are excited to have you on board.\n\n" +
                "Best regards,\n" +
                "Your Application Team");
        Transport.send(message);
    }
}
