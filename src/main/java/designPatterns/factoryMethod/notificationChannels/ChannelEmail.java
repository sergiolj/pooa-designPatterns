package designPatterns.factoryMethod.notificationChannels;

import designPatterns.factoryMethod.NotificationCreator;
import designPatterns.factoryMethod.NotificationProduct;
import designPatterns.factoryMethod.notificationTypes.NotificationThroughEmail;

public class ChannelEmail extends NotificationCreator {

    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughEmail();
    }
}
