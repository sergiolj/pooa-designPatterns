package designpatterns.behavioral.command.menuConsole.commands;


import java.util.Scanner;

import designpatterns.behavioral.command.menuConsole.collections.MyListaDuplaEncadeada;

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
