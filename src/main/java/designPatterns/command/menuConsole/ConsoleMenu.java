package designPatterns.command.menuConsole;



import designPatterns.command.menuConsole.commands.Command;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleMenu {
    private final Map<Integer, Command> optionMenu = new TreeMap<>();
    private final Scanner sc = new Scanner(System.in);
    private static int counter = 0;
    private boolean running = true;


    public void addOption(Command command){
        counter++;
        optionMenu.put(counter, command);
    }

    public void start(){
        int choice = 0;

        while (running) {
            try {
                displayMenu();
                choice = sc.nextInt();
                Command command = optionMenu.get(choice);
                if (command != null) {
                    this.running = command.execute();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Apenas números inteiros [1-" + counter + "]. Tente novamente.");
                sc.nextLine();
            }
        }
    }

    private void displayMenu() {
        for (Map.Entry<Integer, Command> entry : optionMenu.entrySet()){
            System.out.println(entry.getKey() + "] " + entry.getValue().getDescription());
        }
        System.out.println("Digite uma opção de [1-" + (counter) + "]");
    }
}
