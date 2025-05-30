package monitoramento;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TempSensorConcreteSubject system = new TempSensorConcreteSubject();

        try{
            int timer = 0;
            while(timer<20){
                Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                System.out.println("Temperatura: " + system.getTemperature());
                timer += 5;
            }
            system.turnOff();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
