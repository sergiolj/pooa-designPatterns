package designPatterns.command;

public class LightOffCommand implements Command {
    private LightBulb lightBulb;

    public LightOffCommand(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    @Override
    public void execute() {
        lightBulb.turnLightOff();
    }

    @Override
    public void undo() {
        lightBulb.turnLightOn();
    }

    @Override
    public String toString() {
        return "Turn Light Off";
    }
}
