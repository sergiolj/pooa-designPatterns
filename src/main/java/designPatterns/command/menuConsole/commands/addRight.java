package designPatterns.command.menuConsole.commands;


import designPatterns.command.menuConsole.collections.MyListaDuplaEncadeada;

import java.util.Scanner;

public class addRight implements Command{
    private final MyListaDuplaEncadeada<String> list;
    Scanner sc;

    public addRight(MyListaDuplaEncadeada<String> list, Scanner sc) {
        this.sc = sc;
        this.list = list;
    }

    @Override
    public boolean execute() {
        System.out.println("Informe um elemento para adicionar");
        list.adicionarFim(sc.nextLine());
        System.out.println("Elemento adicionado à direita com sucesso");
        return true;
    }

    @Override
    public String getDescription() {
        return "Adicionar elemento à direita ";
    }

    @Override
    public String getErrorMsg() {
        return "";
    }
}
