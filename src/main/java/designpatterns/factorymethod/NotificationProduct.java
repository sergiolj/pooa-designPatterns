package designpatterns.factorymethod;

public interface NotificationProduct {
    void sendNotification(String recipient, String message);
    String getNotificationType();
}
