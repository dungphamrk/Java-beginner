package ChatGPTCode.Presentation;

import MyCode.Entity.Categories;
import MyCode.Entity.Product;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ShopManagement {
    private static final int MAX_CATEGORIES = 100;
    private static final int MAX_PRODUCTS = 1000;
    private final Categories[] categories;
    private final Product[] products;
    private int categoryCount;
    private int productCount;
    private final Scanner sc;

    public ShopManagement() {
        categories = new Categories[MAX_CATEGORIES];
        products = new Product[MAX_PRODUCTS];
        categoryCount = 0;
        productCount = 0;
        sc = new Scanner(System.in);
    }

    public void displayMainMenu() {
        while (true) {
            printMainMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> categoryManagementMenu();
                    case 2 -> productManagementMenu();
                    case 3 -> { return; }
                    default -> System.out.println("Lựa chọn không hợp lệ! Mời nhập lại");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    private void categoryManagementMenu() {
        while (true) {
            printCategoryMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> displayCategories();
                    case 2 -> addCategory();
                    case 3 -> updateCategory();
                    case 4 -> deleteCategory();
                    case 5 -> searchCategory();
                    case 6 -> { return; }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    private void productManagementMenu() {
        while (true) {
            printProductMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> displayProducts();
                    case 2 -> addProduct();
                    case 3 -> updateProduct();
                    case 4 -> deleteProduct();
                    case 5 -> searchProductByName();
                    case 6 -> searchProductByPriceRange();
                    case 7 -> sortProductsByPrice();
                    case 8 -> sellProduct();
                    case 9 -> showProductStatsByCategory();
                    case 10 -> { return; }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    // Category Management Methods
    private void displayCategories() {
        Arrays.stream(categories, 0, categoryCount)
                .filter(Objects::nonNull)
                .forEach(Categories::displayData);
    }

    private void addCategory() {
        if (categoryCount >= MAX_CATEGORIES) {
            System.out.println("Danh sách danh mục đã đầy!");
            return;
        }
        Categories newCatalog = new Categories();
        newCatalog.inputData(sc);
        if (Arrays.stream(categories, 0, categoryCount)
                .anyMatch(c -> c != null && c.getName().equals(newCatalog.getName()))) {
            System.out.println("Tên danh mục đã tồn tại!");
            return;
        }
        categories[categoryCount++] = newCatalog;
        System.out.println("Thêm danh mục thành công!");
    }

    private void updateCategory() {
        System.out.print("Nhập tên danh mục cần cập nhật: ");
        String updateName = sc.nextLine().trim();
        Arrays.stream(categories, 0, categoryCount)
                .filter(c -> c != null && c.getName().equals(updateName))
                .findFirst()
                .ifPresentOrElse(
                        c -> {
                            c.inputData(sc);
                            System.out.println("Cập nhật danh mục thành công!");
                        },
                        () -> System.out.println("Không tìm thấy danh mục!"));
    }

    private void deleteCategory() {
        System.out.print("Nhập tên danh mục cần xóa: ");
        String deleteName = sc.nextLine().trim();
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i] != null && categories[i].getName().equals(deleteName)) {
                categories[i] = categories[categoryCount - 1];
                categories[categoryCount - 1] = null;
                categoryCount--;
                System.out.println("Xóa danh mục thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục!");
    }

    private void searchCategory() {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String searchName = sc.nextLine().trim();
        Arrays.stream(categories, 0, categoryCount)
                .filter(c -> c != null && c.getName().contains(searchName))
                .forEach(Categories::displayData);
    }

    // Product Management Methods
    private void displayProducts() {
        Arrays.stream(products, 0, productCount)
                .filter(Objects::nonNull)
                .forEach(Product::displayData);
    }

    private void addProduct() {
        if (productCount >= MAX_PRODUCTS) {
            System.out.println("Danh sách sản phẩm đã đầy!");
            return;
        }
        Product newProduct = new Product();
        newProduct.inputData(sc);
        if (Arrays.stream(products, 0, productCount)
                .anyMatch(p -> p != null && p.getProductId().equals(newProduct.getProductId()))) {
            System.out.println("Mã sản phẩm đã tồn tại!");
            return;
        }
        products[productCount++] = newProduct;
        System.out.println("Thêm sản phẩm thành công!");
    }

    private void updateProduct() {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String updateId = sc.nextLine().trim();
        Arrays.stream(products, 0, productCount)
                .filter(p -> p != null && p.getProductId().equals(updateId))
                .findFirst()
                .ifPresentOrElse(
                        p -> {
                            p.inputData(sc);
                            System.out.println("Cập nhật sản phẩm thành công!");
                        },
                        () -> System.out.println("Không tìm thấy sản phẩm!"));
    }

    private void deleteProduct() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String deleteId = sc.nextLine().trim();
        for (int i = 0; i < productCount; i++) {
            if (products[i] != null && products[i].getProductId().equals(deleteId)) {
                products[i] = products[productCount - 1];
                products[productCount - 1] = null;
                productCount--;
                System.out.println("Xóa sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    private void searchProductByName() {
        System.out.print("Nhập tên hoặc tiêu đề sản phẩm cần tìm: ");
        String searchKey = sc.nextLine().trim();
        Arrays.stream(products, 0, productCount)
                .filter(p -> p != null && (p.getName().contains(searchKey) || p.getTitle().contains(searchKey)))
                .forEach(Product::displayData);
    }

    private void searchProductByPriceRange() {
        try {
            System.out.print("Nhập giá tối thiểu: ");
            double minPrice = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Nhập giá tối đa: ");
            double maxPrice = Double.parseDouble(sc.nextLine().trim());
            Arrays.stream(products, 0, productCount)
                    .filter(p -> p != null && p.getExportPrice() >= minPrice && p.getExportPrice() <= maxPrice)
                    .forEach(Product::displayData);
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ cho giá!");
        }
    }

    private void sortProductsByPrice() {
        Arrays.sort(products, 0, productCount,
                (p1, p2) -> {
                    if (p1 == null) return 1;
                    if (p2 == null) return -1;
                    return Double.compare(p1.getExportPrice(), p2.getExportPrice());
                });
        System.out.println("Sắp xếp sản phẩm theo giá tăng dần thành công!");
    }

    private void sellProduct() {
        System.out.print("Nhập mã sản phẩm cần bán: ");
        String sellId = sc.nextLine().trim();
        Arrays.stream(products, 0, productCount)
                .filter(p -> p != null && p.getProductId().equals(sellId))
                .findFirst()
                .ifPresentOrElse(
                        p -> {
                            try {
                                System.out.print("Nhập số lượng bán: ");
                                int sellQuantity = Integer.parseInt(sc.nextLine().trim());
                                if (sellQuantity <= 0) {
                                    System.out.println("Số lượng phải lớn hơn 0!");
                                    return;
                                }
                                if (p.getQuantity() >= sellQuantity) {
                                    p.setQuantity(p.getQuantity() - sellQuantity);
                                    System.out.println("Bán sản phẩm thành công!");
                                } else {
                                    System.out.println("Số lượng không đủ để bán!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập số lượng hợp lệ!");
                            }
                        },
                        () -> System.out.println("Không tìm thấy sản phẩm!"));
    }

    private void showProductStatsByCategory() {
        System.out.println("Thống kê số lượng sản phẩm theo danh mục:");
        Arrays.stream(categories, 0, categoryCount)
                .filter(Objects::nonNull)
                .forEach(c -> {
                    long count = Arrays.stream(products, 0, productCount)
                            .filter(p -> p != null && p.getCategoryId() == c.getId())
                            .count();
                    System.out.println(c.getName() + ": " + count + " sản phẩm");
                });
    }

    // Menu printing methods
    private void printMainMenu() {
        System.out.println("""
                *********************SHOP MENU*********************
                1. Quản lý danh mục
                2. Quản lý sản phẩm
                3. Thoát
                Chọn: """);
    }

    private void printCategoryMenu() {
        System.out.println("""
                ********************CATEGORIE MANAGEMENT*********************
                1. Danh sách danh mục
                2. Thêm mới danh mục
                3. Cập nhật danh mục
                4. Xóa danh mục
                5. Tìm kiếm danh mục theo tên
                6. Thoát
                Chọn: """);
    }

    private void printProductMenu() {
        System.out.println("""
                ************************PRODUCT MANAGEMENT*******************
                1. Danh sách sản phẩm
                2. Thêm mới sản phẩm
                3. Cập nhật sản phẩm
                4. Xóa sản phẩm
                5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề
                6. Tìm kiếm sản phẩm theo khoảng giá bán
                7. Sắp xếp sản phẩm theo giá bán tăng dần
                8. Bán sản phẩm
                9. Thống kê số lượng sản phẩm theo danh mục
                10. Thoát
                Chọn: """);
    }

    public static void main(String[] args) {
        new ShopManagement().displayMainMenu();
    }
}