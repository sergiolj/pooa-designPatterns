package designPatterns.command.menuConsole.commands;


import designPatterns.command.menuConsole.collections.MyListaDuplaEncadeada;

public class Listing implements Command {
    private final MyListaDuplaEncadeada<String> list;

    public Listing(MyListaDuplaEncadeada<String> list) {
        this.list = list;
    }

    @Override
    public boolean execute() {
        System.out.println("Exibindo lista de elementos");
        System.out.println(list.toString());
        return true;
    }

    @Override
    public String getDescription() {
        return "Listar elementos";
    }

    @Override
    public String getErrorMsg() {
        return "";
    }
}
