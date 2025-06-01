package monitoramento;

import monitoramento.model.Equipment;

public class TempSensorConcreteObserver implements TempSensorObserver{
    private final TempSensorSubject sensor;
    private final Equipment equipment;

    public TempSensorConcreteObserver(Equipment equipment, TempSensorSubject sensor) {
        this.equipment = equipment;
        this.sensor = sensor;
        sensor.registerObserver(this);
    }

    @Override
    public void update(double temperature) {
        System.out.println("Temperature sensor sent updated information to: " + equipment.getName());
        equipment.update(temperature);
    }
}
