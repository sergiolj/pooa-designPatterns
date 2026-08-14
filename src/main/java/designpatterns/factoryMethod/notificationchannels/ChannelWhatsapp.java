package designpatterns.factoryMethod.notificationChannels;

import designpatterns.factoryMethod.notificationTypes.NotificationThroughWhatsapp;
import designpatterns.factorymethod.NotificationCreator;
import designpatterns.factorymethod.NotificationProduct;

public class ChannelWhatsapp extends NotificationCreator {
    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughWhatsapp();
    }
}
