package designPatterns.builder;

public class Main {
    public static void main(String[] args) {
        PizzaPepperoni pepperoni = new PizzaPepperoni();

        Pizza pizza1 = new Pizza(pepperoni);
        System.out.println(pizza1);

        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        System.out.println(pizzaBuilder);
    }
}
