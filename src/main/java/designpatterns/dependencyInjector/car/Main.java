package designpatterns.dependencyInjector.car;

import designpatterns.dependencyInjector.car.engines.EletricEngine;
import designpatterns.dependencyInjector.car.engines.InternalCombustionEngine;
import designpatterns.factoryMethod.notificationtypes.NotificationSignal;
import designpatterns.factoryMethod.notificationtypes.NotificationThroughSMS;

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
