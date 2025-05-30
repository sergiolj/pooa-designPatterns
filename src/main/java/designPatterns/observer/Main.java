package designPatterns.observer;

import designPatterns.observer.model.Magazine;
import designPatterns.observer.model.Newsweek;
import designPatterns.observer.model.SportsIllustrated;
import designPatterns.observer.model.Time;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        //Criando a Editora
        PublisherConcreteSubject timeInc = new PublisherConcreteSubject();

        //Criando as edições das revistas
        Magazine time25_6 = new Time(Year.of(2025),6);
        Magazine sports25_6 = new SportsIllustrated(Year.of(2025),6);
        Magazine newsweek25_6 = new Newsweek(Year.of(2025),6);

        System.out.println();

        //Criando os assinantes
        SubscriberConcreteObserver sergio = new SubscriberConcreteObserver("Sérgio Lopes",timeInc);
        SubscriberConcreteObserver luma = new SubscriberConcreteObserver("Luma Magalhães",timeInc);

        //Criando assinantes com construtor personalizado
        SubscriberConcreteObserver marcia = new SubscriberConcreteObserver("Márcia Reis", timeInc);


        timeInc.registerObserver(sergio);
        timeInc.registerObserver(luma);

        /**
         *  Ao ser publicado um novo exemplar da revista uma série de métodos são acionados em cascata
         * à lista de revistas (de objetos abstratos) é adicionada a nova revista e a variável última publicação
         * recebe o objeto da nova revista, por fim é acionado o método notificar que é implementado por uma interface
         * da editora, sendo função dela notificar.
         * A função pega a lista de usuários e itera executando a função update passando como parâmetro a
         * última publicação. Pergunta? Como implementar sem passar esse parâmetro?
         * Resposta: Cria um método String na interface Publisher que retorne a última entrada da lista de revistas
         * 
         */

        timeInc.setLatestPublication(time25_6);
        timeInc.setLatestPublication(sports25_6);

        //Removendo subscrição
        timeInc.removeObserver(sergio);

        timeInc.setLatestPublication(newsweek25_6);

    }
}
