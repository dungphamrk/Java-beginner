package Ex8;

public class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }
    @Override
    public double getDiscount() {
        return 0.1;
    }
}
