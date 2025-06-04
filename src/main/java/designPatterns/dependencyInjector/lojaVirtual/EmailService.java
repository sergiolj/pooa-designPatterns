package designPatterns.dependencyInjector.lojaVirtual;

public class EmailService implements NotificationService {

    @Override
    public void sendNotification(Order order) {
            System.out.println("Simulando envio de EMAIL para: " + order.getEMAIL());
            System.out.println("Assunto: Pedido " + order.getStatus());
            System.out.println("Corpo: " + order.messageStatus());
            System.out.println("--------------------------------------");
    }
}

