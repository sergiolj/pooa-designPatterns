package designPatterns.command.menuConsole.commands;

public interface Command {
    boolean execute();
    String getDescription();
    String getErrorMsg();
}
