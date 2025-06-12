package designPatterns.command.menuConsole.commands;

public class Exit implements Command{
    @Override
    public boolean execute() {
        System.out.println("Saindo da aplicação...");
        return false;
    }

    @Override
    public String getDescription() {
        return "Sair do programa";
    }

    @Override
    public String getErrorMsg() {
        return "";
    }
}
