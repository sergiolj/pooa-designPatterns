package designPatterns.factoryMethod.notificationChannels;

import designPatterns.factoryMethod.NotificationCreator;
import designPatterns.factoryMethod.NotificationProduct;
import designPatterns.factoryMethod.notificationTypes.NotificationThroughSMS;

public class ChannelSMS extends NotificationCreator {
    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughSMS();
    }
}
