package monitoramento.model;

public class DigitalDisplay extends Equipment {
    private int color;

    public DigitalDisplay(String name) {
        super(name);
        this.color = 1; // Color 1 can be yellow, for example.
    }

    public void setDisplayInfo(){
        System.out.println("Display updated: " + super.getTemperatureFormatted()+ " Celsius");
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "DigitalDisplay [id=" + super.getId() + "]";
    }

    @Override
    public void updateAll() {
        setDisplayInfo();
    }

}
