package designPatterns.strategy.ecomercePayment;

import designPatterns.factoryMethod.ecomerceUtil.PaymentMethod;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CartStrategy myCart = new CartStrategy();

        myCart.addItem("Nikon Camera", 199);
        myCart.addItem("IPhone 23 ULTRA", 99);

        System.out.println("Total bill: USD " + myCart.getBill());

        myCart.removeItem("Nikon Camera");

        boolean running = true;
        while(running) {
            System.out.println("Total bill: USD " + myCart.getBill());
            System.out.println("Choose a method to pay");
            System.out.println("_______________________");
            for(PaymentMethod option : PaymentMethod.values()) {
                System.out.println("[" + option.getId()+ "] " + option.getDescription());
            }
            System.out.println("Your choice:");
            try{
                int choice = sc.nextInt();
                PaymentMethod paymentMethod = PaymentMethod.getFromId(choice);

                PaymentStrategy strategy = PaymentMethod.factory(paymentMethod);

                if(myCart.checkout(strategy)){
                    System.out.println("Thank you for your order!");
                    running = false;
                }
            }catch (Exception e) {
                System.out.println("Invalid choice, please try again");
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}

