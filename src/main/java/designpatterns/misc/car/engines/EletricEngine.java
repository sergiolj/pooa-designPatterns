package designpatterns.misc.car.engines;

import designpatterns.misc.car.Engine;

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
