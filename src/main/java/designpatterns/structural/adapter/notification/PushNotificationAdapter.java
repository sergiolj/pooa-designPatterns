package designpatterns.structural.adapter.notification;

import java.util.logging.Logger;

import designpatterns.structural.adapter.notification.util.UserId;

public class PushNotificationAdapter implements NotificationService {
	private final Notification notification;
	private final Logger logger = Logger.getLogger("PushNotificationAdapter");

	public PushNotificationAdapter(Notification notification) {
		this.notification = notification;
		
	}

	public void sendNotification(String userId, String subject, String message) {
		if (userId == null || userId.isEmpty()) {
			throw new IllegalArgumentException("Recipient cannot be null or empty");
		}else if(!UserId.isValid(userId)){
			throw new IllegalArgumentException("Invalid device token");
		}
		String pushNotificationMessage = "Push Notification to " + userId + ": " + subject + " - " + message;

		logger.info(pushNotificationMessage);
	}

	@Override
	public void sendNotification() {
		sendNotification(this.notification.recipient(), this.notification.title(), this.notification.message());
	}

}
