package utils;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailUtils {

    public static void sendMail(Session session, String reciever, String subject, String text) {

        MimeMessage message = new MimeMessage(session);

        try {
            message.setRecipients(Message.RecipientType.TO, "reciever");
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println("Message was successfully sent!");
        } catch (MessagingException e) {
            System.out.println("Error while sending: " + e.toString());
        }
    }

    public static Session getSession() {
        Properties props = new Properties();
        InputStream propsInput = null;

        try {
            propsInput = new FileInputStream("src/main/resources/settings.properties");
            props.load(propsInput);
        } catch (IOException ex) {
            System.out.println("app.properties file not found!");
        }

        final String userName = props.getProperty("user.name");
        final String password = props.getProperty("user.password");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        return  session;
    }
}
