package designPatterns.dependencyInjector.lojaVirtual;

import designPatterns.dependencyInjector.lojaVirtual.util.*;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("111",
                "719999932",
                "maria@gmail.com",
                MessageMethod.SMS);

        Order order2 = new Order("1332",
                "719999932",
                "maria@gmail.com",
                MessageMethod.EMAIL);

        EmailService emailService = new EmailService();
        SMSService smsService = new SMSService();

        OrderProcessor osEmail = new OrderProcessor(emailService);
        OrderProcessor osSMS = new OrderProcessor(smsService);

        osEmail.processOrder(order1);
        osSMS.processOrder(order2);
    }
}
