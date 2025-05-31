package monitoramento.model;

public class DigitalDisplay extends Equipment {
    private int color;

    public DigitalDisplay() {
        super();
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
}
