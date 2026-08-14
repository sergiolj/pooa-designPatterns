package designpatterns.command.menuConsole;


import java.util.Scanner;

import designpatterns.command.menuConsole.collections.MyListaDuplaEncadeada;
import designpatterns.command.menuConsole.commands.*;

public class MainMenuTest {
    public static void main(String[] args) {
        MyListaDuplaEncadeada<String> list = new MyListaDuplaEncadeada<>();
        Scanner sc = new Scanner(System.in);

        ConsoleMenu menu = new ConsoleMenu();

        menu.addOption(new addLeft(list, sc));
        menu.addOption(new addRight(list, sc));
        menu.addOption(new Listing(list));
        menu.addOption(new Exit());

        menu.start();
    }
}
