package Ex10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard(11111000);
        PaymentMethod debitCard = new DebitCard(123111);
        PaymentMethod cash = new Cash(22231);
        creditCard.processPayment();
        creditCard.processPayment(123, "USD");
        System.out.println();
        debitCard.processPayment();
        debitCard.processPayment(123, "EUR");
        System.out.println();
        cash.processPayment();
        cash.processPayment(32323, "JPY");
    }
}
