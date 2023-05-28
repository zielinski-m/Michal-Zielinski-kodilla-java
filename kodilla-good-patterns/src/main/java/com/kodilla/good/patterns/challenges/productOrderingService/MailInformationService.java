package com.kodilla.good.patterns.challenges.productOrderingService;

public class MailInformationService implements InformationService {
    public void inform(User user) {
        System.out.println("Sending email to user: " + user.getEmail());
        System.out.println("Subject: Order Confirmation");
        System.out.println("To: " + user.getEmail());
        System.out.println("Content: Your order has been confirmed.");
        System.out.println("Email sent successfully.");
    }
}
