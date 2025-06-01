package monitoramento;
/**
 * O padrão de projetos utilizado para essa implementação é o Observer, este padrão é organizado através de duas
 * interfaces e duas classes concretas, as interfaces chamadas de Subject (objeto monitorado) e Observer (objetos a
 * serem notificados) definem os métodos que as classes concretas devem implementar, são eles: void update() (Observer)
 * que vai atualizar os objetos a serem notificados e registerObserver, removeObserver e notifyObservers (Subject)
 * que vão organizar as listas de Observers e notificar os mesmos através do método update(). Assim o número e as
 * características dos objetos Observers  pode mudar sem modificar as classes que fazem o monitoramento, necessitando
 * apenas se registrar ao monitorador.
 */

import monitoramento.model.AudibleAlarm;
import monitoramento.model.DigitalDisplay;

public class Main {
    public static void main(String[] args) {
        TempSensorConcreteSubject sensor = new TempSensorConcreteSubject();

        DigitalDisplay display = new DigitalDisplay("Display Sala");
        AudibleAlarm audibleAlarm = new AudibleAlarm("Alarme Sala");

        TempSensorConcreteObserver observer1 = new TempSensorConcreteObserver(display, sensor);
        TempSensorConcreteObserver observer2 = new TempSensorConcreteObserver(audibleAlarm, sensor);


    }
}
