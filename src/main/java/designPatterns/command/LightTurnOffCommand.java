package designPatterns.command;

public class LightTurnOffCommand implements LightCommand {
    private LightBulb lightBulb;

    public LightTurnOffCommand(LightBulb lightBulb) {
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
