package Ex8;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getDiscount() {
        return 0;
    }
    public double getDiscount(int quantity){
        if(quantity >100){
            return 0.05;
        }else {
            return 0;
        }
    }
    public double getFinalPrice(){
        return price - (getDiscount()*price);
    }
    public double getFinalPrice(int quantity){
        return price - (getDiscount(quantity)*price);
    }

}