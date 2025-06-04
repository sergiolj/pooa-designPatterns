package designPatterns.builder;

import designPatterns.builder.concreteConstructor.PepperoniBuilder;

public class Main {
    public static void main(String[] args) {
        Pizzaiolo pizzaiolo = new Pizzaiolo();
        Pizza clientOrder = pizzaiolo.makeSpecialPizza(new PepperoniBuilder());
        System.out.println();
    }
}
