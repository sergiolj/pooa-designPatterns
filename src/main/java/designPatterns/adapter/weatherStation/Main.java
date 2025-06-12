package designPatterns.adapter.weatherStation;

public class Main {
    public static void main(String[] args) {
        FahrenheitSensor fahrenheitSensor = new FahrenheitSensor();
        FahrenheitCelsiusAdapter adapter = new FahrenheitCelsiusAdapter(fahrenheitSensor);

        System.out.printf("Weather station temperature: %.2f °C%n", adapter.getTemperature());
        System.out.printf("Original temperature: %.2f °F%n", fahrenheitSensor.getFahrenheit());
    }
}
