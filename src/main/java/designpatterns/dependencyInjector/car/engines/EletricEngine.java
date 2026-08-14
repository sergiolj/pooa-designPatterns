package designpatterns.dependencyInjector.car.engines;

import designpatterns.dependencyInjector.car.Engine;

public class EletricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Eletric engine started");
    }

    @Override
    public void stop() {
        System.out.println("Eletric engine stopped");

    }
}
