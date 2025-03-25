import java.util.HashMap;
import java.util.LinkedHashMap;

public class Ex3 {
    public static void main(String[] args) {
        HashMap<String, Integer> products =  new LinkedHashMap<>();
        products.put("Tai nghe", 111);
        products.put("Iphone", 222);
        products.put("Laptop", 333);
        products.put("Chuột", 1000);
        System.out.println("Danh sách sản phẩm theo thứ tự là: "+ products);
        products.put("Laptop", 9999);
        products.remove("Tai nghe");
        System.out.println("Danh sách sản phẩm sau khi xóa: "+ products);
    }
}
