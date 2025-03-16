package Ex10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard(1000);
        PaymentMethod debitCard = new DebitCard(1000);
        PaymentMethod cash = new Cash(1000);

        System.out.println("CreditCard:");
        creditCard.processPayment();
        creditCard.processPayment(1000, "USD");

        System.out.println("\nDebitCard:");
        debitCard.processPayment();
        debitCard.processPayment(1000, "EUR");

        System.out.println("\nCash:");
        cash.processPayment();
        cash.processPayment(1000, "VND");
    }
}
