package designPatterns.command;

public class Main {
    public static void main(String[] args) {
        //Criação das lâmpadas
        LightBulb estar = new LightBulb("Estar");
        LightBulb cozinha = new LightBulb("Cozinha");

        Command estarOn = new LightOnCommand(estar);
        Command estarOff = new LightOffCommand(estar);

        Command cozinhaOn = new LightOnCommand(cozinha);
        Command cozinhaOff = new LightOffCommand(cozinha);

        //Configurando o controle remoto
        RemoteInvoker remote = new RemoteInvoker();
        remote.setCommand(estarOn);
        remote.executeCommand();

        remote.setCommand(estarOff);
        remote.executeCommand();

        remote.undoCommand();
    }
}
