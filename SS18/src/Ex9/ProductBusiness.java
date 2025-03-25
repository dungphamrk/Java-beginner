package Ex9;

import java.util.Scanner;

import static Ex9.ProductManager.products;

public class ProductBusiness {
    public static void addProduct(Scanner scanner){
        System.out.println("Nhập số lượng sản phẩm cần thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập mã sản phẩm: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            double price=0;
            int quantity=0;
            while (true)
            {
                System.out.print("Nhập giá sản phẩm: ");
                price = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập số lượng sản phẩm: ");
                quantity = Integer.parseInt(scanner.nextLine());
                if (price < 0 || quantity < 0) {
                    System.err.println("Giá trị ko đc là số âm, vui lòng nhập lại");
                    continue;
                }
                break;
            }
            products.put(id, new Product(id, name, price, quantity));
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm cần cập nhật: ");
        int id = scanner.nextInt();
        Product product = products.get(id);
        if (product == null) {
            System.out.println("Sản phẩm không tồn tại.");
            return;
        }
        System.out.print("Nhập giá mới: ");
        double newPrice = scanner.nextDouble();
        if (newPrice < 0) {
            System.out.println("Giá không hợp lệ. Cập nhật thất bại.");
            return;
        }
        product.setPrice(newPrice);
        System.out.print("Nhập số lượng mới: ");
        int newQuantity = scanner.nextInt();
        if (newQuantity < 0) {
            System.out.println("Số lượng không hợp lệ. Cập nhật thất bại.");
            return;
        }
        product.setQuantity(newQuantity);
        System.out.println("Sản phẩm đã được cập nhật!");
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm (id) để xóa: ");
        int id = scanner.nextInt();
        if (products.remove(id) != null) {
            System.out.println("Sản phẩm đã được xóa!");
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    public static void calculateTotalValue() {
        double totalValue = 0;
        for (Product product : products.values()) {
            totalValue += product.getPrice() * product.getQuantity();
        }
        System.out.println("Tổng giá trị sản phẩm trong kho: " + totalValue);
    }
}
