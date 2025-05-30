package designPatterns.command;

public class Main {
    public static void main(String[] args) {
        //Criação das lâmpadas
        LightBulb estar = new LightBulb("Estar");
        LightBulb cozinha = new LightBulb("Cozinha");

        LightCommand estarOn = new LightTurnOnCommand(estar);
        LightCommand estarOff = new LightTurnOffCommand(estar);

        LightCommand cozinhaOn = new LightTurnOnCommand(cozinha);
        LightCommand cozinhaOff = new LightTurnOffCommand(cozinha);

        //Configurando o controle remoto
        RemoteControlInvoker remote = new RemoteControlInvoker();
        remote.setCommand(estarOn);
        remote.executeCommand();

        remote.setCommand(estarOff);
        remote.executeCommand();

        remote.undoCommand();
    }
}
