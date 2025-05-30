package designPatterns.command;

public class LightTurnOnCommand implements LightCommand {
    private final LightBulb lightBulb;

    public LightTurnOnCommand(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    @Override
    public void execute() {
        lightBulb.turnLightOn();
    }

    @Override
    public void undo() {
        lightBulb.turnLightOff();
    }

    @Override
    public String toString() {
        return "Turn Light On";
    }
}
