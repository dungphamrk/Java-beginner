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
        System.out.println("Tổng tiền phải trả: " + totalAmount);
    }
}
