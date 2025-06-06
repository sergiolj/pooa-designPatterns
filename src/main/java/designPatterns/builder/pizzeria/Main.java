package designPatterns.builder.pizzeria;

public class Main {
    public static void main(String[] args) {
        Pizzaiolo pizzaiolo = new Pizzaiolo();
        Pizza clientOrder = pizzaiolo.makeSpecialPizza(new PepperoniBuilder());
        Pizza clientOrder2 = pizzaiolo.makeStandardPizza(new PepperoniBuilder());
        Pizza clientOrder3 = pizzaiolo.makeSimplePizza(new Pizza.Builder());

        Pizza customClientOrder3 = clientOrder3.toBuild().addTopping("bacon").build();

        System.out.println(clientOrder);
        System.out.println(clientOrder2);
        System.out.println(clientOrder3);
        System.out.println(customClientOrder3);
    }
}
