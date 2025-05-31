package monitoramento;

import monitoramento.model.AudibleAlarm;
import monitoramento.model.DigitalDisplay;

public class Main {
    public static void main(String[] args) {
        TempSensorConcreteSubject sensor = new TempSensorConcreteSubject();
        TemSensorConcreteObserver observer = new TemSensorConcreteObserver(sensor);

        AudibleAlarm audibleAlarm = new AudibleAlarm();
        DigitalDisplay digitalDisplay = new DigitalDisplay();

        //sensor.registerObserver(audibleAlarm);
        //sensor.registerObserver(digitalDisplay);


    }
}
