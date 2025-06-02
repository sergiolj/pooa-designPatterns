package designPatterns.factoryMethod.notificationTypes;

import designPatterns.factoryMethod.NotificationProduct;

public class NotificationThroughWhatsapp implements NotificationProduct {
    @Override
    public void sendNotification(String recipient, String message) {
        //Implements business rules to send notification
        System.out.println("Whatsapp message sent to " + recipient + ": " + message);
    }

    @Override
    public String getNotificationType() {
        return "Whatsapp";
    }
}
