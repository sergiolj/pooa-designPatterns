package designPatterns.adapter.exchangeCurrency;

public class Main {
    public static void main(String[] args) {
        ExchangeDollarAdaptee exchangeDollar = new ExchangeDollarAdaptee(100);
        ExchangeRealTarget adapter = new ExchangeDollarAdapter(exchangeDollar);

        System.out.printf("Valor em reais: R$ %.2f%n \n", adapter.getValue());
        System.out.printf("Corresponde a US$ %.2f%n \n" , exchangeDollar.getAmount());
    }
}
