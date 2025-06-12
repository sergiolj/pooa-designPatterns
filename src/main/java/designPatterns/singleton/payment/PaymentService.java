package designPatterns.singleton.payment;

public enum PaymentService {
    INSTANCE;
    private String APIKey = "";
    private boolean connected = false;


    private PaymentService() {
        System.out.println("Initializing Payment Service...");
        //lógica de inicialização
        System.out.println("Payment Service initialized.");
    }

    public static PaymentService getInstance() {
        return INSTANCE;
    }

    public void connect(String APIKey) {
        this.APIKey = APIKey;
        connected = true;
        System.out.println("Connected to Payment Service.");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Disconnected from Payment Service.");
    }

    public boolean processPayment(double amount) {
        if (connected) {
            System.out.printf("Processing payment of U$ %.2f\n", amount);
            return true;
        }else{
            System.out.println("Error. Unable to process payment. Service is disconnected.");
            return false;
        }

    }
}
