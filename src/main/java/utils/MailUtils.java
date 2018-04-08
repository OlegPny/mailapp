package utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

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
            System.out.println("Ошибка при отправке письма: " + e.toString());
        }
    }
}
