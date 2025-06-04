package designPatterns.dependencyInjector.car;

import designPatterns.dependencyInjector.car.engines.EletricEngine;
import designPatterns.dependencyInjector.car.engines.InternalCombustionEngine;
import designPatterns.factoryMethod.notificationTypes.NotificationSignal;
import designPatterns.factoryMethod.notificationTypes.NotificationThroughSMS;

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
