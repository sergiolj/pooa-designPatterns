package designPatterns.command;

public class RemoteInvoker {
    private Command command;
    private Command undoCommand;

    public RemoteInvoker() {
        this.command = null;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            System.out.println("Executing command: " + command);
            command.execute();
            undoCommand = command;
        }else{
            System.out.println("No command to be executed. Please set a command first.");
        }
    }
    public void undoCommand() {
        if (undoCommand != null) {
            System.out.println("Undoing command: " + undoCommand);
            undoCommand.undo();
            undoCommand = null;
        }else{
            System.out.println("No command to be undo.");
        }
    }

}
