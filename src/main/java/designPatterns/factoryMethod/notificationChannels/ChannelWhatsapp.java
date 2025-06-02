package designPatterns.factoryMethod.notificationChannels;

import designPatterns.factoryMethod.NotificationCreator;
import designPatterns.factoryMethod.NotificationProduct;
import designPatterns.factoryMethod.notificationTypes.NotificationThroughWhatsapp;

public class ChannelWhatsapp extends NotificationCreator {
    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughWhatsapp();
    }
}
