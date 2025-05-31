package monitoramento;

public class TemSensorConcreteObserver  implements TempSensorObserver{
    private final TempSensorConcreteSubject equipment;

    public TemSensorConcreteObserver(TempSensorConcreteSubject equipment) {
        this.equipment = equipment;
    }

    @Override
    public void update() {
        System.out.println("Temperature sensor: " + equipment.getTemperature());
    }
}
