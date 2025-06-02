package designPatterns.factoryMethod;

public abstract class NotificationCreator {

    protected abstract NotificationProduct createNotificationProduct();

    public void processSending (String recipient, String message) {
        NotificationProduct notification = createNotificationProduct();

        System.out.println("\nSending " + notification.getNotificationType() + " notification");

        notification.sendNotification(recipient, message);

        System.out.println("\n" + notification.getNotificationType() + " notification to " + recipient
                + " sent successfully");
    }

}
