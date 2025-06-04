package designPatterns.dependencyInjector.car.engines;

import designPatterns.dependencyInjector.car.Engine;

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
