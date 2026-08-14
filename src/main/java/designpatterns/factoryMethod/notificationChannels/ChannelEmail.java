package designpatterns.factoryMethod.notificationChannels;

import designpatterns.factoryMethod.notificationTypes.NotificationThroughEmail;
import designpatterns.factorymethod.NotificationCreator;
import designpatterns.factorymethod.NotificationProduct;

public class ChannelEmail extends NotificationCreator {

    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughEmail();
    }
}
