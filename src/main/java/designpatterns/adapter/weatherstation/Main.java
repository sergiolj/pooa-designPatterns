package designpatterns.adapter.weatherstation;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        FahrenheitSensor fahrenheitSensor = new FahrenheitSensor();
        FahrenheitCelsiusAdapter celsiusAdapter = new FahrenheitCelsiusAdapter(fahrenheitSensor);
        FahrenheitKelvinAdapter kelvinAdapter = new FahrenheitKelvinAdapter(fahrenheitSensor);
        
        Logger logger = Logger.getLogger(Main.class.getName());
        
        ConsoleHandler consoleHandler = new ConsoleHandler();

        consoleHandler.setFormatter(null);
        
        logger.info("Celsius adapter temperature: " + celsiusAdapter.getTemperature() + " °C");
        logger.info("Sensor original temperature data: " + fahrenheitSensor.getTemperature() + "°F");
        logger.info("Kelvin adapter temperature: " + kelvinAdapter.getTemperature() + " K");

    }
}
