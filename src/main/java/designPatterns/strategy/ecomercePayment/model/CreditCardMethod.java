package designPatterns.strategy.ecomercePayment.model;

import designPatterns.strategy.ecomercePayment.PaymentStrategy;
import designPatterns.strategy.ecomercePayment.util.PromoResult;

public class CreditCardMethod implements PaymentStrategy {

    private final double serviceFeeTax = 2.5;
    private double discountPercentage = 0;
    /**
     * In this method the discount is a fixed value, it can be equals to the serviceFeeTax, but not higher.
     */
    public static double DISCOUNT = 0;

    public CreditCardMethod() {
    }

    @Override
    public double getDiscount() {
        return CreditCardMethod.DISCOUNT;
    }

    @Override
    public boolean setDiscount(double discount) {
        if (discount <= this.serviceFeeTax) {
            CreditCardMethod.DISCOUNT = discount;
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
        double payment = bill + serviceFeeTax - (bill * (this.discountPercentage /100));
        System.out.println("Value to pay USD: " + payment);
        System.out.println("Enter your credit card number: 5535 5344 4134 4343");
        System.out.println("Processing request...");
        System.out.println("Payment approved!");
        return true;
    }

    @Override
    public boolean setPromoCode(String promoCode) {
        PromoResult result = new PromoResult();
        boolean validCode = result.validateCode(promoCode).isValid();
        if(validCode){
            this.discountPercentage = result.getPercentage();
            return true;
        }else{
            return false;
        }
    }
}
