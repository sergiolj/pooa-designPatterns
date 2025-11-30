package designPatterns.strategy.payment;

public class PIXMethod implements PaymentStrategy {
    private double totalAmount;
    private double serviceFeeTax = 0;

    /**
     * In this method the discount is a percentage of the bill.
     */
    private double discount = 5;

    public PIXMethod() {}

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean setDiscount(double discount) {
        if(discount > 0 && discount <= 10){
            this.discount = discount;
            return true;
        }else{
            System.out.println("Default discount applied!("+ this.discount +" %). Discount set cannot be applied.");
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
        return bill * (1-(discount /100d));
    }

    @Override
    public boolean pay(double bill) {
        boolean aproved = true;
        double payment = bill * (1-(discount /100d));
        System.out.println("Generating QR Code to payment: " + payment);
        System.out.println("Waiting to payment confirmation...");

        if(aproved){
            System.out.println("Payment confirmed!");
            return true;
        }else{
            return false;
        }

    }


}
