package designPatterns.decorator.coffeeShop;

public class Main {
    public static void main(String[] args) {
        Beverage espressoCoffee = new Coffee();
        System.out.printf("Order: %s | Price US$: %.2f%n" , espressoCoffee.description(), espressoCoffee.price());

        Beverage capuccino = new Coffee();
        capuccino = new Milk(capuccino);
        capuccino = new Chocolate(capuccino);
        capuccino = new Cinnamon(capuccino);

        System.out.printf("Order: %s | Price US$: %.2f%n" , capuccino.description(), capuccino.price());

    }
}
