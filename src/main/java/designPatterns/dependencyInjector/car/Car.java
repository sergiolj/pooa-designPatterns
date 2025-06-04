package designPatterns.dependencyInjector.car;

import designPatterns.factoryMethod.NotificationProduct;

public class Car {
    private final Engine engine;
    private final NotificationProduct notificator;
    private final String startMsg = "Engine started successfully";
    private final String stoptMsg = "Engine stopped successfully";


    //Injeção de dependência via Construtor da classe
    public Car(Engine engine, NotificationProduct notificator) {
        this.engine = engine;
        this.notificator = notificator;
    }

    public String msgRecipient(){
        String type = notificator.getNotificationType();
        String recipient = "";
        if(type.equals("SMS")){
            recipient = "Car owner smartphone";
        }else if(type.equals("Onboard Signal")){
            recipient = "Car computer";
        }
        return recipient;
    }

    public void start() {
        engine.start();
        System.out.println("Car started.");
        notificator.sendNotification(msgRecipient(), startMsg);
    }

    public void stop() {
        engine.stop();
        System.out.println("Car stopped.");
        notificator.sendNotification(msgRecipient(), stoptMsg);
    }
}
