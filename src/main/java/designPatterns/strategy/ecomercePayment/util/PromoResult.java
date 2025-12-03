package designPatterns.strategy.ecomercePayment.util;

public class PromoResult {

    private boolean valid;
    private String message;
    private double percentage;

    public PromoResult(){}

    public PromoResult(boolean valid, String message, double percentage) {
        this.valid = valid;
        this.message = message;
        this.percentage = percentage;
    }

    public PromoResult validateCode(String promoCode) {
        switch (promoCode){
            case "10%OFF":
                this.percentage = 10D;
                this.valid = true;
                this.message = "You have successfully validated this promo code";
                return this;

            case "20%OFF":
                this.percentage = 20D;
                this.valid = true;
                this.message = "You have successfully validated this promo code";
                return this;

            default:
                this.valid = false;
                this.message = "Invalid promo code";
                return this;
        }
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    public double getPercentage() {
        return percentage;
    }
}
