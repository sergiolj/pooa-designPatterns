package designPatterns.factoryMethod;

public interface NotificationProduct {
    void sendNotification(String recipient, String message);
    String getNotificationType();
}
