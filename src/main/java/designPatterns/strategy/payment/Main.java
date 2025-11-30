package designPatterns.strategy.payment;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CartStrategy myCart = new CartStrategy();

        myCart.addItem("Nikon Camera", 199);
        myCart.addItem("IPhone 23 ULTRA", 99);

        System.out.println("Total bill: USD " + myCart.getBill());

        myCart.removeItem("Nikon Camera");

        System.out.println("Total bill: USD " + myCart.getBill());
        PaymentStrategy pix = new PIXMethod();
        PaymentStrategy creditCard = new CreditCardMethod();

        System.out.println("Choose a payment strategy:");
        System.out.println("1. PIX: USD " + (pix.valueToPay(myCart.getBill())));
        System.out.println("2. CreditCard: USD " + (creditCard.valueToPay(myCart.getBill())));

        System.out.println("How strategy you choose to pay with? (1) (2)?");
        char choice = sc.next().charAt(0);
        if (choice == '1'){
            myCart.checkout(pix);
        }else if (choice == '2'){
            myCart.checkout(creditCard);
        }else {
            System.out.println("Invalid choice.");
        }

        System.out.println(myCart.getBill());
        sc.close();
    }
}

