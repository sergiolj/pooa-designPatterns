package designPatterns.command;

public class LightOnCommand implements Command {
    private final LightBulb lightBulb;

    public LightOnCommand(LightBulb lightBulb) {
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
