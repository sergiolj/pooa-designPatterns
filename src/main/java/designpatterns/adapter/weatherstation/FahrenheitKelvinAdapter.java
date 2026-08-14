package designpatterns.adapter.weatherstation;

public class FahrenheitKelvinAdapter implements TemperatureSensor {
	private final FahrenheitSensor fahrenheitSensor;

	public FahrenheitKelvinAdapter(FahrenheitSensor fahrenheitSensor) {
		this.fahrenheitSensor = fahrenheitSensor;
	}

	@Override
	public double getTemperature() {
		double sensorData = fahrenheitSensor.getTemperature();
		return ((sensorData - 32) * 5 / 9 + 273.15);
	}

}
