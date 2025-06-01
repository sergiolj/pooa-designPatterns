package monitoramento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TempSensorConcreteSubject implements TempSensorSubject, Runnable{
    private final List<TempSensorObserver> observers;
    private double temperature = 20;//Valor arbitrado
    private volatile boolean online;
    private Random ran = new Random();


    public TempSensorConcreteSubject() {
        this.observers = new ArrayList<>();
        this.online = true;
        startMonitoring();
    }

    public double updateTemperature() {
        //Implementa a leitura atual do sensor de temperatura
        double maxVariation = 2.5;
        double readTemperature;
        readTemperature= ran.nextDouble(temperature-maxVariation, temperature+maxVariation);
        return readTemperature;
    }

    public double getTemperature() {
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
        for (TempSensorObserver observer : observers) {
            observer.update(this.temperature);
        }
    }

    public void turnOff() {
        online = false;
    }

    @Override
    public void run() {
        System.out.println("Initializing temperature sensor...");
        double readTemperature;
        while(this.online){
            try {
                readTemperature = updateTemperature();
                if(readTemperature != this.temperature) {
                    this.temperature = readTemperature;
                    System.out.printf("New temperature: [%.1f]\n", this.temperature) ;
                    notifyObservers();
                    System.out.println();
                }
                Thread.sleep(TimeUnit.SECONDS.toMillis(5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
