package designPatterns.strategy.payment;

public interface PaymentStrategy {
    double getDiscount();
    boolean setDiscount(double discount);
    void setServiceFeeTax(double serviceFeeTax);
    double getServiceFeeTax();
    double valueToPay(double bill);
    boolean pay(double bill);
}
