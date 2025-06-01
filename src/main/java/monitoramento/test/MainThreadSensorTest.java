package monitoramento.test;

import monitoramento.TempSensorConcreteSubject;
import monitoramento.model.AudibleAlarm;
import monitoramento.model.DigitalDisplay;
import monitoramento.model.Equipment;

import java.util.concurrent.TimeUnit;

public class MainThreadSensorTest {
    public static void main(String[] args) {
        TempSensorConcreteSubject system = new TempSensorConcreteSubject();
        try{
            int timer = 0;
            while(timer<20){
                Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                System.out.println("Temperatura: " + system.getTemperature());
                timer += 10;
            }
            system.turnOff();
        }catch(InterruptedException e){
            System.out.println("Erro ao atualizar temperatura");
        }
        AudibleAlarm audibleAlarm = new AudibleAlarm("Alarme Sala");
        DigitalDisplay digitalDisplay = new DigitalDisplay("Display Sala");
        System.out.println(Equipment.getCount());


    }






}
