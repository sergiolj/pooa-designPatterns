package designPatterns.factoryMethod;

import designPatterns.factoryMethod.notificationChannels.ChannelEmail;
import designPatterns.factoryMethod.notificationChannels.ChannelSMS;
import designPatterns.factoryMethod.notificationChannels.ChannelWhatsapp;

public class Main {
    public static void main(String[] args) {
        /*
         *Usa a classe abstrata para criar uma referência e depois atribui objetos concretos (subclasses)
         *NotificationCreator channel = new ChannelEmail();
         */

        NotificationCreator channel;

        //O canal da mensagem está definido pela subclasse
        channel = new ChannelEmail();

        /*
         * O método que processa a mensagem recebe os parâmetros de destinatário e mensagem
         * Esse método é genérico e se adapta para executar as notificações conforme seu tipo usando a classe
         * abstrata implementada na subclasse para criar o objeto que irá efetivamente enviar a notificação.
         */


        channel.processSending("jhonDoe@nasa.com", "Embarque para a Lua autorizado.");


        channel = new ChannelSMS();
        channel.processSending("+557199999999", "Você acaba de ganhar um milhão no jogo do tigrinho! "
                + "Clique no link suspeito para receber seu prêmio antes que expire!");

        channel = new ChannelWhatsapp();
        channel.processSending("+557199999999", "Sua fatura do cartão de crédito Visa vence em breve.");
    }
}
