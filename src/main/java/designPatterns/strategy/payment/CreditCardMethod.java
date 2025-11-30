package designPatterns.strategy.payment;

public class CreditCardMethod implements PaymentStrategy {

    private final double serviceFeeTax = 2.5;
    /**
     * In this method the discount is a fixed value, it can be equals to the serviceFeeTax, but not higher.
     */
    private double discount = 0;

    public CreditCardMethod() {
    }

    @Override
    public double getDiscount() {
        return this.discount;
    }

    @Override
    public boolean setDiscount(double discount) {
        if (discount <= this.serviceFeeTax) {
            this.discount = discount;
            return true;
        } else {
            System.out.println("Discount can not be higher than service fee tax: " + this.serviceFeeTax);
            return false;
        }

    }

    @Override
    public void setServiceFeeTax(double serviceFeeTax) {
        System.out.println("This method has a fixed service fee tax of " + serviceFeeTax);
    }

    @Override
    public double getServiceFeeTax() {
        return this.serviceFeeTax;
    }

    @Override
    public double valueToPay(double bill) {
        return bill + this.serviceFeeTax;
    }

    @Override
    public boolean pay(double bill) {
        double payment = bill + serviceFeeTax;
        System.out.println("Enter your credit card number: 5535 5344 4134 4343");
        System.out.println("Processing request...");
        System.out.println("Payment approved!");
        return true;
    }
}
