package Ex10;

public abstract class PaymentMethod {
    protected double amount;
    public PaymentMethod(double amount) {
        this.amount = amount;
    }
    abstract void processPayment();
    abstract double calculateFee();
    public void processPayment(double amount, String currency) {
        double totalAmount = amount + calculateFee();
        System.out.println("Tổng tiền phải trả: " + totalAmount + " " + currency);
    }
}
