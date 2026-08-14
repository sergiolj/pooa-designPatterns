package designpatterns.factoryMethod.notificationChannels;

import designpatterns.factoryMethod.notificationTypes.NotificationThroughSMS;
import designpatterns.factorymethod.NotificationCreator;
import designpatterns.factorymethod.NotificationProduct;

public class ChannelSMS extends NotificationCreator {
    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughSMS();
    }
}
