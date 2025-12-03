package designPatterns.factoryMethod.ecomerceUtil;

import designPatterns.strategy.ecomercePayment.PaymentStrategy;
import designPatterns.strategy.ecomercePayment.model.BrazilianBankSlip;
import designPatterns.strategy.ecomercePayment.model.CreditCardMethod;
import designPatterns.strategy.ecomercePayment.model.PIXMethod;

public enum PaymentMethod {
    PIX(1,
            "PIX method with " + PIXMethod.DISCOUNT * 100 + "% OFF"),
    CREDIT_CARD(2,
            "Credit Card Pay in 10 installments with no interest"),
    BRZ_BANK_SLIP(3,
            "Brazilian Bank Slip with " + BrazilianBankSlip.DISCOUNT * 100 + "% OFF");

    private final int id;
    private final String description;


    private PaymentMethod(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStrategy factory(PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case CREDIT_CARD:
                return new CreditCardMethod();
            case PIX:
                return new PIXMethod();
            case BRZ_BANK_SLIP:
                return new BrazilianBankSlip();
            default:
                throw new IllegalArgumentException("Payment Method option invalid!");
        }
    }

    public static PaymentMethod getFromId(int id) {
        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            if (paymentMethod.getId() == id) {
                return paymentMethod;
            }
        }
        throw new IllegalArgumentException("Payment Method option invalid! " + id);
    }

}
