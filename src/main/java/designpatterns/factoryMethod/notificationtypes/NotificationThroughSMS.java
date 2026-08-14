package designpatterns.factoryMethod.notificationTypes;

import designpatterns.factorymethod.NotificationProduct;

public class NotificationThroughSMS implements NotificationProduct {


    @Override
    public void sendNotification(String recipient, String message) {
        //Implements business rules to send notification
        System.out.println("SMS sent to " + recipient + ": " + message);
    }

    @Override
    public String getNotificationType() {
        return "SMS";
    }

}
