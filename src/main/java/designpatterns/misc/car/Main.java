package designpatterns.misc.car;

import designpatterns.misc.car.engines.EletricEngine;
import designpatterns.misc.car.engines.InternalCombustionEngine;
import designpatterns.creational.factorymethod.notificationtypes.NotificationSignal;
import designpatterns.creational.factorymethod.notificationtypes.NotificationThroughSMS;

public class Main {
    public static void main(String[] args) {
        Car newCar = new Car(new EletricEngine(), new NotificationSignal());
        newCar.start();
        newCar.stop();

        Car newCar2 = new Car(new InternalCombustionEngine(), new NotificationThroughSMS());
        newCar2.start();
        newCar2.stop();
    }
}
