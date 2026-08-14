package designpatterns.structural.adapter.notification;

import java.util.logging.Logger;

import designpatterns.structural.adapter.notification.util.EmailAddress;

public class EmailNotificationAdapter implements NotificationService {
	private final Notification notification;
	private final Logger logger = Logger.getLogger(EmailNotificationAdapter.class.getName());
	
	public EmailNotificationAdapter(Notification notification) {
			this.notification = notification;
	}
	
	
	public void sendNotification(String email, String subject, String message) {
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Recipient cannot be null or empty");
		}else if(!email.contains("@")) {
			throw new IllegalArgumentException("Invalid email address");
		}
		
		if(EmailAddress.isValid(email)) {
			String emailMessage = "Email to " + email + ": " + subject + " - " + message;
			logger.info(emailMessage);
		}
	}

	@Override
	public void sendNotification() {
		sendNotification(this.notification.recipient(), this.notification.title(), this.notification.message());
		
	}
}
