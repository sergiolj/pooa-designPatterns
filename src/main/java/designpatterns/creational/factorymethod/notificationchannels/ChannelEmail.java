package designpatterns.creational.factorymethod.notificationchannels;

import designpatterns.creational.factorymethod.notificationtypes.NotificationThroughEmail;
import designpatterns.creational.factorymethod.NotificationCreator;
import designpatterns.creational.factorymethod.NotificationProduct;

public class ChannelEmail extends NotificationCreator {

    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughEmail();
    }
}
