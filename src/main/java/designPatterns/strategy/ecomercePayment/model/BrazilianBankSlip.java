package designPatterns.strategy.ecomercePayment.model;

import designPatterns.strategy.ecomercePayment.PaymentStrategy;

public class BrazilianBankSlip implements PaymentStrategy {

    public static final double DISCOUNT = 0.03;

    public BrazilianBankSlip(){}


    @Override
    public double getDiscount() {
        return BrazilianBankSlip.DISCOUNT;
    }

    @Override
    public boolean setDiscount(double discount) {
        return true;
    }

    @Override
    public void setServiceFeeTax(double serviceFeeTax) {

    }

    @Override
    public double getServiceFeeTax() {
        return 0;
    }

    @Override
    public double valueToPay(double bill) {
        return 0;
    }

    @Override
    public boolean pay(double bill) {
        double payment = bill  - (bill * (BrazilianBankSlip.DISCOUNT /100));
        System.out.println("Value to pay USD: " + payment);
        System.out.println("Scanning QRCode...");
        System.out.println("Processing request...");
        System.out.println("Payment approved!");
        return true;
    }

    @Override
    public boolean setPromoCode(String promoCode) {
        return true;
    }
}
