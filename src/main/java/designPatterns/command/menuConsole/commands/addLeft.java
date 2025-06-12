package designPatterns.command.menuConsole.commands;


import designPatterns.command.menuConsole.collections.MyListaDuplaEncadeada;

import java.util.Scanner;

public class addLeft implements Command{
    private final MyListaDuplaEncadeada<String> list;
    private final Scanner sc;


    public addLeft(MyListaDuplaEncadeada<String> list, Scanner sc) {
        this.sc = sc;
        this.list = list;
    }

    @Override
    public boolean execute() {
        System.out.println("Informe um elemento para adicionar");
        list.adicionarInicio(sc.nextLine());
        System.out.println("Elemento adicionado à esquerda com sucesso");
        return true;
    }

    @Override
    public String getDescription() {
        return "Adicionar elemento à esquerda";

    }

    @Override
    public String getErrorMsg() {
        return "";
    }
}
