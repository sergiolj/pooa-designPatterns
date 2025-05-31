package monitoramento.model;

public class AudibleAlarm  extends Equipment {
    private int volume;

    public AudibleAlarm() {
        super();
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
}
