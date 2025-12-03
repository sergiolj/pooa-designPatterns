package designPatterns.strategy.ecomercePayment.model;

import designPatterns.strategy.ecomercePayment.PaymentStrategy;

public class PIXMethod implements PaymentStrategy {
    private double totalAmount;
    private double serviceFeeTax = 0;

    /**
     * In this method the discount is a percentage of the bill.
     */
    public static double DISCOUNT = 0.05;

    public PIXMethod() {}

    @Override
    public double getDiscount() {
        return DISCOUNT;
    }


    @Override
    public boolean setDiscount(double discount) {
        if(discount > 0 && discount <= 10){
            PIXMethod.DISCOUNT = discount;
            return true;
        }else{
            System.out.println("Default discount applied!("+ PIXMethod.DISCOUNT +" %). Discount set cannot be applied.");
            return false;
        }
    }

    @Override
    public void setServiceFeeTax(double serviceFeeTax) {
        this.serviceFeeTax = serviceFeeTax;
    }


    @Override
    public double getServiceFeeTax() {
        return this.serviceFeeTax;
    }

    @Override
    public double valueToPay(double bill) {
        return bill * (1-(DISCOUNT /100d));
    }

    @Override
    public boolean pay(double bill) {
        boolean approved = true;
        double payment = bill * (1-(DISCOUNT /100d));
        System.out.println("Generating QR Code to payment: " + payment);
        System.out.println("Waiting to payment confirmation...");

        if(approved){
            System.out.println("Payment confirmed!");
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean setPromoCode(String promoCode) {
        return false;
    }


}
