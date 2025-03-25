import java.util.*;

public class Ex5 {
    public static void main(String[] args) {
        TreeMap<String, Integer> products =  new TreeMap<>();
        products.put("Tai nghe", 111);
        products.put("Iphone", 999);
        products.put("Laptop", 888);
        products.put("Chuột", 1000);
        products.put("Bàn phím", 1900);
        System.out.println("Các sản phẩm có giá từ 500 đến 1500 theo thứ tự tăng dần là: ");
        for (Map.Entry<String, Integer> entry : products.reversed().entrySet()) {
            if (entry.getValue() >= 500 && entry.getValue() <= 1500) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}
