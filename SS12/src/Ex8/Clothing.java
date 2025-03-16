package Ex8;

public class Clothing extends  Product{
    public Clothing(String name, double price) {
        super(name, price);
    }
    public double getDiscount(){
        return 0.2;
    }
}
