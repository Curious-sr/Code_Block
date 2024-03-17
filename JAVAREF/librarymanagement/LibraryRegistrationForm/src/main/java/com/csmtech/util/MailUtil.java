package com.csmtech.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.csmtech.model.Registration;

public class MailUtil {
	public static final String username = "meghacsm2001@gmail.com";
    public static final String password = "oytuugjxnknnngas";

    public static void sendEmailGmailTLS(Registration register) {

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                            }
                    });
            try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("meghacsm2001@gmail.com"));
                    message.setRecipients(
                            Message.RecipientType.TO,
                            InternetAddress.parse(register.getEmail())
                    );
                    message.setSubject("Greeting From Abhijit");
                    message.setText("Hello"+register.getApplicantName()+", College Registration Successfully Done.\n"
                    		+ "you are allowed to go through this.........");

                    Transport.send(message);
                    System.out.println("Mail Sent Successfully.");

            } catch (MessagingException e) {
                    e.printStackTrace();
                    System.out.println(e);
            }
    }
}
