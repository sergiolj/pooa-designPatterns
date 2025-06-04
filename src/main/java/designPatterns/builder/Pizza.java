package designPatterns.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizza {
    private final String dough;
    private final String sauce;
    private List<String> topping = new ArrayList<>();
    private final boolean stuffedCrust;
    private final boolean glutenFree;

    Pizza(PizzaBuilderInterface pizzaBuilder) {
        this.dough = pizzaBuilder.makeDough();
        this.sauce = pizzaBuilder.makeTomatoSauce();
        this.topping = pizzaBuilder.addTopping();
        this.stuffedCrust = pizzaBuilder.withCrust();
        this.glutenFree =  pizzaBuilder.isGlutenFree();
    }

    public List<String> getTopping() {
        return topping;
    }

    public String getDough() {
        return dough;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping=" + topping +
                ", stuffedCrust=" + stuffedCrust +
                ", glutenFree=" + glutenFree +
                '}';
    }
}

class PizzaBuilder implements PizzaBuilderInterface {
    Pizza pizza;
    Scanner sc = new Scanner(System.in);

    @Override
    public String makeDough() {
        System.out.println("Please enter the dough type: ");
        return this.sc.nextLine();
    }

    @Override
    public String makeTomatoSauce() {
        System.out.println("Please enter the tomato sauce type: ");
        return sc.nextLine();
    }

    @Override
    public List<String> addTopping() {
        boolean finnished = false;
        String topping;
        while (!finnished) {
            System.out.println("Adding topping or (X to exit)");
            topping = this.sc.nextLine();
            if (topping.equalsIgnoreCase("X")){
                finnished = true;
            }else{
                this.pizza.getTopping().add(topping);
            }
        }
        return this.pizza.getTopping();
    }

    @Override
    public Pizza getPizza() {
        this.sc.close();
        return this.pizza;
    }

    @Override
    public boolean withCrust() {
        System.out.println("With crust? (Y/N) ");
        String choice = sc.nextLine();
        return choice.equalsIgnoreCase("Y");
    }

    @Override
    public boolean isGlutenFree() {
        return pizza.getDough().equalsIgnoreCase("Gluten-Free");
    }
}
