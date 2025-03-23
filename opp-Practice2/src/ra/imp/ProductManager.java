package ra.entity;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager {
    private Scanner scanner;

    public ProductManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputMultipleProducts() {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            new Product().inputData(scanner);
        }
    }

    public void displayAllProducts() {
        if (Product.getProducts().isEmpty()) {
            System.out.println("Chưa có sản phẩm nào!");
            return;
        }
        Product.getProducts().forEach(Product::displayData);
    }

    public void calculateAllProfits() {
        Product.getProducts().forEach(Product::calProfit);
        System.out.println("Đã tính lợi nhuận cho tất cả sản phẩm!");
    }

    public void sortByProfit() {
        Product.getProducts().sort(Comparator.comparing(Product::getProfit).reversed());
        System.out.println("Đã sắp xếp theo lợi nhuận giảm dần!");
        displayAllProducts();
    }

    public void statisticByPriceRange() {
        System.out.print("Nhập giá từ: ");
        float fromPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá đến: ");
        float toPrice = Float.parseFloat(scanner.nextLine());

        long count = Product.getProducts().stream()
                .filter(p -> p.getExportPrice() >= fromPrice && p.getExportPrice() <= toPrice)
                .count();
        System.out.println("Số sản phẩm trong khoảng giá " + fromPrice + " - " + toPrice + ": " + count);
    }

    public void searchByName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        List<Product> results = Product.getProducts().stream()
                .filter(p -> p.getProductName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào!");
        } else {
            results.forEach(Product::displayData);
        }
    }

    public void importProduct() {
        System.out.print("Nhập mã sản phẩm cần nhập: ");
        String id = scanner.nextLine();
        Product product = Product.getProducts().stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElse(null);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        System.out.print("Nhập số lượng cần thêm: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        product.setQuantity(product.getQuantity() + quantity);
        System.out.println("Đã cập nhật số lượng!");
    }

    public void sellProduct() {
        System.out.print("Nhập tên sản phẩm cần bán: ");
        String name = scanner.nextLine();
        Product product = Product.getProducts().stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        System.out.print("Nhập số lượng cần bán: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        if (quantity > product.getQuantity()) {
            System.out.println("Không đủ số lượng để bán!");
        } else {
            product.setQuantity(product.getQuantity() - quantity);
            System.out.println("Đã bán sản phẩm!");
        }
    }

    public void updateStatus() {
        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
        String id = scanner.nextLine();
        Product product = Product.getProducts().stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElse(null);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        product.setStatus(!product.isStatus());
        System.out.println("Đã cập nhật trạng thái!");
    }
}