package com.esprit.veltun.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMail {
    public static void sendMail(String recepient, String text ) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String myEmailAccount = "veltun2023@gmail.com";
        String password = "mlmticvztafwoqaj";

        Session session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmailAccount,password);
            }
        });
        Message message = prepareMessage(session, myEmailAccount, recepient, text);
        Transport.send(message);
        System.out.println("message sent ");
    }
    private static Message prepareMessage(Session session, String myEmailAccount, String recepient, String text) {
        Message message1= new MimeMessage(session);
        try {
            message1.setFrom(new InternetAddress(myEmailAccount));
            message1.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message1.setSubject("Password recovery email");
            message1.setText(text);
            return message1;
        } catch (Exception e) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
}
