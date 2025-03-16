package Ex10;

public class CreditCard extends PaymentMethod {
    public CreditCard(double amount) {
        super(amount);
    }

    @Override
    double calculateFee() {
        return amount * 0.02;
    }

    @Override
    void processPayment() {
        double totalAmount = amount + calculateFee();
        System.out.println("--- Credit Card ---");
        System.out.println("Total Payment (CreditCard): " + totalAmount);
    }
}
