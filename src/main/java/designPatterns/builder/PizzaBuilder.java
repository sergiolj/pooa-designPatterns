package designPatterns.builder;

public interface PizzaBuilder {
    void makeDough();
    void makeTomatoSauce();
    void addTopping(String topping);
    void getPizza();
}
