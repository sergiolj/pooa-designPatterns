package designPatterns.dependencyInjector.lojaVirtual;

public class SMSService implements NotificationService {

    @Override
    public void sendNotification(Order order) {
        System.out.println("Simulando envio de SMS para: " + order.getSMS());
        System.out.println("Assunto: Pedido " + order.getStatus());
        System.out.println("Corpo: " + order.messageStatus());
        System.out.println("--------------------------------------");
    }
}
