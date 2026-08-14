package designpatterns.structural.adapter.weatherstation;

public class FahrenheitCelsiusAdapter implements TemperatureSensor{
    private final FahrenheitSensor fahrenheitSensor;

    public FahrenheitCelsiusAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperature() {
        double sensorData = fahrenheitSensor.getTemperature();
        double celsius = ((sensorData - 32)*5.0 /9.0);
        return celsius;
    }

}
