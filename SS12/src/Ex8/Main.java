package Ex8;

public class Main {
    public static void main(String[] args) {
        Product eProduct = new Electronics("Laptop", 123123);
        Product cProduct = new Clothing("T-Shirt", 123);
        Product fProduct = new Food("Apple", 1111);

        System.out.println(eProduct.name);
        System.out.println(eProduct.price);
        System.out.println("giá mặc định: " + eProduct.getFinalPrice());
        System.out.println("giá khi mua nhiều sản phẩm: " + eProduct.getFinalPrice(111));

        System.out.println(cProduct.name);
        System.out.println(cProduct.price);
        System.out.println("giá mặc định: " + cProduct.getFinalPrice());
        System.out.println("giá khi mua nhiều sản phẩm: " + cProduct.getFinalPrice(222));

        System.out.println(fProduct.name);
        System.out.println(fProduct.price);
        System.out.println("giá mặc định : " + fProduct.getFinalPrice());
        System.out.println("giá khi mua nhiều sản phẩm: " + fProduct.getFinalPrice(333));
    }
}
