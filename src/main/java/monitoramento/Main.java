package monitoramento;

public class Main {
    public static void main(String[] args) {
        TempSensorConcreteSubject system = new TempSensorConcreteSubject();
        System.out.println(system.getTemperature());
        system.updateTemperature();
        System.out.println(system.getTemperature());
        system.updateTemperature();
        System.out.println(system.getTemperature());
    }
}
