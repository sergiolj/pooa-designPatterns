package designpatterns.factoryMethod.notificationtypes;

import designpatterns.factorymethod.NotificationProduct;

public class NotificationThroughEmail implements NotificationProduct {

    @Override
    public void sendNotification(String recipient, String message) {
        //Implements business rules to send notification
        System.out.println("Email sent to " + recipient + ": " + message);

    }

    @Override
    public String getNotificationType() {
        return "E-mail";
    }

}
