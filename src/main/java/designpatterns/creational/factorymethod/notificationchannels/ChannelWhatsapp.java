package designpatterns.creational.factorymethod.notificationchannels;

import designpatterns.creational.factorymethod.notificationtypes.NotificationThroughWhatsapp;
import designpatterns.creational.factorymethod.NotificationCreator;
import designpatterns.creational.factorymethod.NotificationProduct;

public class ChannelWhatsapp extends NotificationCreator {
    @Override
    protected NotificationProduct createNotificationProduct() {
        return new NotificationThroughWhatsapp();
    }
}
