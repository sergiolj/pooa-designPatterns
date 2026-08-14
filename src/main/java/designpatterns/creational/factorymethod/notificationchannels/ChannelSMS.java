package designpatterns.creational.factorymethod.notificationchannels;

import designpatterns.creational.factorymethod.notificationtypes.NotificationThroughSMS;
import designpatterns.creational.factorymethod.NotificationCreator;
import designpatterns.creational.factorymethod.NotificationProduct;

public class ChannelSMS extends NotificationCreator {
    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughSMS();
    }
}
