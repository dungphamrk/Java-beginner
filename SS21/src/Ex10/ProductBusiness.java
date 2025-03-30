package Ex10;

import java.util.Scanner;

import static Ex10.Main.cart;
import static Ex10.Main.products;

public class ProductBusiness {
    public static void displayData() {
        System.out.println("Danh sách sản phẩm: ");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public static void addProductToCart(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        String productId = scanner.nextLine();
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Lỗi: Sản phẩm không tồn tại!");
            return;
        }
        try {
            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            cart.addToCart(product, quantity);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số lượng không hợp lệ!");
        }
    }

    static void removeProductFromCart(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String productId = scanner.nextLine();
        cart.removeFromCart(productId);
    }
}
