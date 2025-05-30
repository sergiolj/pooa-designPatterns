package designPatterns.command;

public class RemoteControlInvoker {
    private LightCommand lightCommand;
    private LightCommand undoLightCommand;

    public RemoteControlInvoker() {
        this.lightCommand = null;
    }

    public void setCommand(LightCommand lightCommand) {
        this.lightCommand = lightCommand;
    }

    public void executeCommand() {
        if (lightCommand != null) {
            System.out.println("Executing command: " + lightCommand);
            lightCommand.execute();
            undoLightCommand = lightCommand;
        }else{
            System.out.println("No command to be executed. Please set a command first.");
        }
    }
    public void undoCommand() {
        if (undoLightCommand != null) {
            System.out.println("Undoing command: " + undoLightCommand);
            undoLightCommand.undo();
            undoLightCommand = null;
        }else{
            System.out.println("No command to be undo.");
        }
    }

}
