package designpatterns.misc.car.engines;

import designpatterns.misc.car.Engine;

public class InternalCombustionEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Internal Combustion engine started");
    }

    @Override
    public void stop() {
        System.out.println("Internal Combustion engine stopped");

    }
}
