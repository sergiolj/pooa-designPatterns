package monitoramento.model;

public class AudibleAlarm  extends Equipment {
    private int volume;

    public AudibleAlarm(String name) {
        super(name);
    }

    public void triggerAlarm() {
        System.out.println("Alarm triggered. Temperature out of range: " + super.getTemperatureFormatted());
    }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 10) {
            throw new IllegalArgumentException("Volume must be between 0 and 10");
        }else{
            this.volume = volume;
        }
    }
    @Override
    public String toString() {
        return "Audible Alarm [id=" + super.getId() + "]";
    }

    @Override
    public void updateAll() {
        if (temperature < 12.0 || temperature > 28.0) {
            triggerAlarm();
        }
    }

}
