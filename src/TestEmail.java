/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sexon
 */

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class TestEmail {
    public static void main(String[] args) {
        System.out.println("Testing email credentials...");
        
        final String username = "linxonkerby@gmail.com"; // your email
        final String password = "pwopjmtyyferbpcb";  // ← REPLACE THIS!
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
            new jakarta.mail.Authenticator() {
                protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new jakarta.mail.PasswordAuthentication(username, password);
                }
            });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, 
                InternetAddress.parse(username)); // Sends email to yourself
            message.setSubject("Test Email from Java");
            message.setText("SUCCESS! Your app password works correctly.");
            
            System.out.println("Sending email...");
            Transport.send(message);
            System.out.println("✓✓✓ SUCCESS! Email sent successfully!");
            System.out.println("Check your inbox: " + username);
            
        } catch (MessagingException e) {
            System.err.println("✗✗✗ FAILED! Could not send email.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
