package monitoramento;

import monitoramento.model.AudibleAlarm;
import monitoramento.model.DigitalDisplay;

public class Main {
    public static void main(String[] args) {
        TempSensorConcreteSubject sensor = new TempSensorConcreteSubject();

        DigitalDisplay display = new DigitalDisplay("Display Sala");
        AudibleAlarm audibleAlarm = new AudibleAlarm("Alarme Sala");

        TempSensorConcreteObserver observer1 = new TempSensorConcreteObserver(display, sensor);
        TempSensorConcreteObserver observer2 = new TempSensorConcreteObserver(audibleAlarm, sensor);


    }
}
