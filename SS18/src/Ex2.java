import java.util.HashMap;

public class Ex2 {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Tai nghe", 111);
        products.put("Iphone", 222);
        products.put("Laptop", 333);
        products.put("Chuột", 1000);
        System.out.println("Sản phẩm Laptop có trong Map không: "+ products.containsKey("Laptop"));
        System.out.println("Có sản phẩm nào có giá trị bằng 1000 không: "+ products.containsValue(1000));
    }
}
