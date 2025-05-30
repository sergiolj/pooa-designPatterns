package monitoramento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TempSensorConcreteSubject implements TempSensorSubject, Runnable{
    private List<TempSensorObserver> observers;
    private int temperature = 20;//Valor arbitrado
    private volatile boolean online;
    private Random ran = new Random();

    public TempSensorConcreteSubject(List<TempSensorObserver> observers) {
        this.observers = observers;
        this.online = true;
        startMonitoring();
    }
    public TempSensorConcreteSubject() {
        this.observers = new ArrayList<>();
        this.online = true;
        startMonitoring();
    }

    public int updateTemperature() {
        //Implementa a leitura atual do sensor de temperatura
        temperature = ran.nextInt(temperature-5,temperature+5);
        return temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void registerObserver(TempSensorObserver observer) {
        if(observers != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(TempSensorObserver observer) {
        if(observers != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {

    }

    public void turnOffSystem() {
        online = false;
    }

    @Override
    public void run() {
        while(this.online){
            try {
                int currentTemp = updateTemperature();
                if(currentTemp != temperature) {
                    notifyObservers();
                }
                Thread.sleep(TimeUnit.SECONDS.toMillis(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
