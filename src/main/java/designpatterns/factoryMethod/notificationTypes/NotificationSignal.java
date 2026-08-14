package designpatterns.factoryMethod.notificationTypes;

import designpatterns.factorymethod.NotificationProduct;

public class NotificationSignal implements NotificationProduct {

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Onboarding signal sending notification to " + recipient + ": " + message);
    }

    @Override
    public String getNotificationType() {
        return "Onboarding signal";
    }
}
