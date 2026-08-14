package designpatterns.factoryMethod.notificationchannels;

import designpatterns.factoryMethod.notificationtypes.NotificationThroughEmail;
import designpatterns.factorymethod.NotificationCreator;
import designpatterns.factorymethod.NotificationProduct;

public class ChannelEmail extends NotificationCreator {

    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughEmail();
    }
}
