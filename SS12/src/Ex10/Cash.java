package Ex10;

public class Cash extends PaymentMethod{
    public Cash(double amount) {
        super(amount);
    }

    @Override
    double calculateFee() {
        return 0;
    }

    @Override
    void processPayment() {
        System.out.println("Tổng tiền phải trả: " + amount);
    }
}
