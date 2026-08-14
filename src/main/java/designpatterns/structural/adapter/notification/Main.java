package designpatterns.structural.adapter.notification;

public class Main {
	public static void main(String[] args) {
		Notification notification1 = new Notification("71987654321", "Hello", "This is a test notification by SMS.");
		Notification notification2 = new Notification("JhonDo@email.com", "Hello", "This is a test notification by Email.");
		Notification notification3 = new Notification("user123", "Hello User!", "This is a test notification by Push.");
		
		NotificationService sms = new SMSNotificationAdapter(notification1);
		NotificationService email = new EmailNotificationAdapter(notification2);
		NotificationService push = new PushNotificationAdapter(notification3);
		sms.sendNotification();
		email.sendNotification();
		push.sendNotification();
	}
}