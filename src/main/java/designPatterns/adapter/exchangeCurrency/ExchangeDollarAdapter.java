package designPatterns.adapter.exchangeCurrency;

public class ExchangeDollarAdapter implements ExchangeRealTarget {
    private final ExchangeDollarAdaptee exchangeDollar;
    private double exchangeRate = 5.30;

    public ExchangeDollarAdapter(ExchangeDollarAdaptee exchangeDollar) {
        this.exchangeDollar = new ExchangeDollarAdaptee(exchangeRate);
    }

    @Override
    public double getValue() {
        //Adaptação: Converte o valor de dólar para real
        double amountDollar = exchangeDollar.getAmount();
        return amountDollar * exchangeRate;
    }

    @Override
    public void setValue(double value) {
        //Adaptação: Converte o valor de Real para Dólar
        double amountDollar = value / exchangeRate;
        exchangeDollar.setAmount(amountDollar);
    }

    public ExchangeDollarAdaptee getExchangeDollar() {
        return exchangeDollar;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
