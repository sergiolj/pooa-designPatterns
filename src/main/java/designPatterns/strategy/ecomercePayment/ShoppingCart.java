package designPatterns.strategy.ecomercePayment;

public class ShoppingCart {

        private double valorTotal;

        public ShoppingCart(double valorTotal) {
            this.valorTotal = valorTotal;
        }

        // O PROBLEMA ESTÁ AQUI:
        // Se surgir uma nova regra ou novo meio de pagamento,
        // mexemos nessa classe principal. Perigoso!
        public void finalizarCompra(String meioPagamento) {
            if (meioPagamento.equals("PIX")) {
                double desconto = valorTotal * 0.10; // 10% desconto
                System.out.println("Pagando via PIX: R$ " + (valorTotal - desconto));
                System.out.println("Gerando QR Code...");
            }
            else if (meioPagamento.equals("CARTAO")) {
                System.out.println("Pagando via Cartão de Crédito: R$ " + valorTotal);
                System.out.println("Validando limite...");
            }
            else if (meioPagamento.equals("BOLETO")) {
                System.out.println("Gerando Boleto: R$ " + valorTotal);
                System.out.println("Boleto enviado por e-mail.");
            }
            else {
                throw new IllegalArgumentException("Meio de pagamento inválido");
            }
        }

    }
