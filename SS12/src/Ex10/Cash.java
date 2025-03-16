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
        System.out.println("--- Cash ---");
        System.out.println("Total Payment (Cash): " + amount);
    }
}
