package Ex10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Ex10.ProductBusiness.*;

public class Main {
    public static Map<String, Product> products =  new HashMap<>();
    public static ShoppingCart cart = new ShoppingCart();
    public static void main(String[] args) {
        products.put("P001", new Product("P001", "Quần áo", 100.0));
        products.put("P002", new Product("P002", "Son", 200.0));
        products.put("P003", new Product("P003", "Kim cương", 300.0));
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----------------MENU-----------------");
            System.out.println("1. Xem danh sách sản phẩm sẵn có");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Hiển thị tổng tiền");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn từ 1 - 6: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayData();
                    break;
                case 2:
                    addProductToCart(scanner);
                    break;
                case 3:
                    removeProductFromCart(scanner);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1 - 6");
            }
        }while (true);

    }


}
