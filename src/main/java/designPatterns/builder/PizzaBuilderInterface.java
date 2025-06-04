package designPatterns.builder;

import java.util.List;

public interface PizzaBuilderInterface {
    String makeDough();
    String makeTomatoSauce();
    List<String> addTopping();
    Pizza getPizza();
    boolean withCrust();
    boolean isGlutenFree();
}
