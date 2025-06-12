package designPatterns.singleton.payment;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = PaymentService.INSTANCE;

        paymentService.connect("abs3232$%@");
        paymentService.processPayment(32.42);
        paymentService.disconnect();

    }
}
