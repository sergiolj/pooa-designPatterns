package monitoramento;

public interface TempSensorSubject extends Runnable {
    void registerObserver(TempSensorObserver observer);
    void removeObserver(TempSensorObserver observer);
    void notifyObservers();

    default void startMonitoring() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
