package monitoramento.model;

import java.text.DecimalFormat;

public abstract class Equipment {
    private static int count = 0;
    private String name;
    private String description;
    private final int id;
    protected static double temperature;
    private DecimalFormat df = new DecimalFormat("#.#");

    public Equipment(String name) {
        this.name = name;
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getTemperatureFormatted() {
        return df.format(temperature) + " °C";
    }

    public String getName() {
        return name;
    }

    public abstract void updateAll();

    public void update(double temperature){
        Equipment.temperature = temperature;
        updateAll();
    }
}
