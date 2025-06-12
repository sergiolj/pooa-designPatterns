package designPatterns.adapter.exchangeCurrency;

/**
 * O Adaptee é a peça que é incompatível.
 * Nesse caso um serviço de câmbio em dólares
 */
public class ExchangeDollarAdaptee {
    private double amount;

    public ExchangeDollarAdaptee(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
