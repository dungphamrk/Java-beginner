package Ex10;

public class DebitCard extends PaymentMethod{
    public DebitCard(double amount) {
        super(amount);
    }
    @Override
    double calculateFee() {
        return amount * 0.01;
    }
    @Override
    void processPayment() {
        double totalAmount = amount + calculateFee();
        System.out.println("Tổng tiền phải trả: " + totalAmount);
    }
}
