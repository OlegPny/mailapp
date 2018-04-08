package application;

import utils.MailUtils;

import javax.mail.Session;
import java.util.Scanner;

public class ApplicationMain {

    public static void main(String[] args) {

        System.out.println("Введите email получателя и нажмите \"enter\":");
        String reciever = readInput();
        System.out.println("Введите тему письма и нажмите \"enter\":");
        String subject = readInput();
        System.out.println("Введите текст письма и нажмите \"enter\":");
        String text = readInput();

        Session session = MailUtils.getSession();
        MailUtils.sendMail(session, reciever, subject, text);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
