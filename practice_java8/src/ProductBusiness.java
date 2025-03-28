import entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductBusiness {
    private static List<Product> products = new ArrayList<>();

    public static void listProducts() {
        products.forEach(Product::displayData);
    }

    public static void addProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        products.add(product);
    }

    public static void sortProducts(Scanner scanner) {
        System.out.println("1. Sắp xếp tăng dần");
        System.out.println("2. Sắp xếp giảm dần");
        System.out.print("Chọn điều kiện sắp xếp: ");
        int sortChoice = Integer.parseInt(scanner.nextLine());
        if (sortChoice == 1) {
            products.sort(Comparator.comparing(Product::getPrice));
        } else {
            products.sort(Comparator.comparing(Product::getPrice).reversed());
        }
        System.out.println("Sắp xếp thành công!");
    }

    public static void filterProducts(Scanner scanner) {
        System.out.println("1. Lọc theo giá");
        System.out.println("2. Lọc theo tên");
        System.out.print("Chọn điều kiện lọc: ");
        int filterChoice = Integer.parseInt(scanner.nextLine());
        ra.util.ProductFilter filter;
        if (filterChoice == 1) {
            System.out.print("Nhập giá tối thiểu: ");
            float minPrice = Float.parseFloat(scanner.nextLine());
            System.out.print("Nhập giá tối đa: ");
            float maxPrice = Float.parseFloat(scanner.nextLine());
            filter = product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice;
        } else {
            System.out.print("Nhập tên sản phẩm cần tìm: ");
            String name = scanner.nextLine();
            filter = product -> product.getProductName().toLowerCase().contains(name.toLowerCase());
        }
        List<Product> filteredProducts = products.stream()
                .filter(filter::filter)
                .toList();
        if (filteredProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào!");
        } else {
            filteredProducts.forEach(Product::displayData);
        }
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.next();
        List<Product> foundProducts = products.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(name.toLowerCase()))
                .toList();
        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào!");
        } else {
            foundProducts.forEach(Product::displayData);
        }
    }

    public static void deleteProductById(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = scanner.nextInt();
        products.removeIf(product -> product.getProductId() == id);
        System.out.println("Xóa sản phẩm thành công!");
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = products.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst()
                .orElse(null);
        if (product != null) {
            product.inputData(scanner);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Sản phẩm không tồn tại!");
        }
    }
}
