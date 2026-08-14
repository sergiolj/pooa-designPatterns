package designpatterns.adapter.notification;

import java.util.logging.Logger;

import designpatterns.adapter.notification.util.PhoneNumber;

public class SMSNotificationAdapter implements NotificationService {
	private final Notification notification;
	Logger logger = Logger.getLogger(SMSNotificationAdapter.class.getName());
	
	public SMSNotificationAdapter(Notification notification) {
		this.notification = notification;
	}

	public void sendNotification(String phone, String tittle, String msg) {
		if (phone == null || phone.isEmpty()) {
			throw new IllegalArgumentException("Recipient cannot be null or empty");
		}else if(PhoneNumber.isValid(phone)) {
			String smsMessage = "SMS to " + phone + ": " + tittle + " - " + msg;
			logger.info(smsMessage);
		}
	}

	@Override
	public void sendNotification() {
		sendNotification(this.notification.recipient(), this.notification.title(), this.notification.message());
	}
}

