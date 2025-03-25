package Ex9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {
    public static Map<Integer, Product> products = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("------------------------ Quản lý sản phẩm --------------------------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Cập nhật sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Tính tổng giá trị sản phẩm trong kho");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ProductBusiness.addProduct(scanner);
                    break;
                case 2:
                    ProductBusiness.updateProduct(scanner);
                    break;
                case 3:
                    ProductBusiness.deleteProduct(scanner);
                    break;
                case 4:
                    ProductBusiness.calculateTotalValue();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 5");
            }
        } while (true);
    }
}
