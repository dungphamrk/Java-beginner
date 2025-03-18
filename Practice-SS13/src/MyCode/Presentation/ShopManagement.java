package MyCode.Presentation;

import MyCode.Entity.Categories;
import MyCode.Entity.Product;

import java.util.Scanner;

public class ShopManagement {
    private Categories[] categories = new Categories[100];
    private Product[] products = new Product[1000];
    private int categoryCount = 0;
    private int productCount = 0;
    private Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        while (true) {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    categoryManagementMenu();
                    break;
                case 2:
                    productManagementMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Mời nhập lại");
            }
        }
    }

    private void categoryManagementMenu() {
        while (true) {
            System.out.println("********************CATEGORIE MANAGEMENT*********************");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < categoryCount; i++) {
                        if (categories[i] != null) {
                            categories[i].displayData();
                        }
                    }
                    break;
                case 2:
                    if (categoryCount < categories.length) {
                        Categories newCatalog = new Categories();
                        newCatalog.inputData(sc);
                        // Kiểm tra trùng tên
                        boolean isDuplicate = false;
                        for (int i = 0; i < categoryCount; i++) {
                            if (categories[i].getName().equals(newCatalog.getName())) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (!isDuplicate) {
                            categories[categoryCount++] = newCatalog;
                            System.out.println("Thêm danh mục thành công!");
                        } else {
                            System.out.println("Tên danh mục đã tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách danh mục đã đầy!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập tên danh mục cần cập nhật: ");
                    String updateName = sc.nextLine();
                    for (int i = 0; i < categoryCount; i++) {
                        if (categories[i] != null && categories[i].getName().equals(updateName)) {
                            categories[i].inputData(sc);
                            System.out.println("Cập nhật danh mục thành công!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên danh mục cần xóa: ");
                    String deleteName = sc.nextLine();
                    for (int i = 0; i < categoryCount; i++) {
                        if (categories[i] != null && categories[i].getName().equals(deleteName)) {
                            categories[i] = categories[categoryCount - 1];
                            categories[categoryCount - 1] = null;
                            categoryCount--;
                            System.out.println("Xóa danh mục thành công!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên danh mục cần tìm: ");
                    String searchName = sc.nextLine();
                    for (int i = 0; i < categoryCount; i++) {
                        if (categories[i] != null && categories[i].getName().contains(searchName)) {
                            categories[i].displayData();
                        }
                    }

                    break;
                case 6:
                    return;
            }
        }
    }

    private void productManagementMenu() {
        while (true) {
            System.out.println("************************PRODUCT MANAGEMENT*******************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
            System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
            System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn (1 - 10): ");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < productCount; i++) {
                        if (products[i] != null) {
                            products[i].displayData();
                        }
                    }
                    break;
                case 2:
                    if (productCount < products.length) {
                        Product p = new Product();
                        p.inputData(sc);
                        // Kiểm tra trùng mã sản phẩm
                        boolean isDuplicate = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(p.getProductId())) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (!isDuplicate) {
                            products[productCount++] = p;
                            System.out.println("Thêm sản phẩm thành công!");
                        } else {
                            System.out.println("Mã sản phẩm đã tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách sản phẩm đã đầy!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String updateId = sc.nextLine();
                    for (int i = 0; i < productCount; i++) {
                        if (products[i] != null && products[i].getProductId().equals(updateId)) {
                            products[i].inputData(sc);
                            System.out.println("Cập nhật sản phẩm thành công!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String deleteId = sc.nextLine();
                    for (int i = 0; i < productCount; i++) {
                        if (products[i] != null && products[i].getProductId().equals(deleteId)) {
                            products[i] = products[productCount - 1];
                            products[productCount - 1] = null;
                            productCount--;
                            System.out.println("Xóa sản phẩm thành công!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên hoặc tiêu đề sản phẩm cần tìm: ");
                    String searchKey = sc.nextLine();
                    for (int i = 0; i < productCount; i++) {
                        if (products[i] != null && (products[i].getName().contains(searchKey) || products[i].getTitle().contains(searchKey))) {
                            products[i].displayData();
                        }
                    }
                    break;
                case 6:
                    System.out.print("Nhập giá tối thiểu: ");
                    double minPrice = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập giá tối đa: ");
                    double maxPrice = Double.parseDouble(sc.nextLine());
                    for (int i = 0; i < productCount; i++) {
                        if (products[i] != null && products[i].getExportPrice() >= minPrice && products[i].getExportPrice() <= maxPrice) {
                            products[i].displayData();
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < productCount - 1; i++) {
                        for (int j = i + 1; j < productCount; j++) {
                            if (products[i] != null && products[j] != null && products[i].getExportPrice() > products[j].getExportPrice()) {
                                Product temp = products[i];
                                products[i] = products[j];
                                products[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp sản phẩm theo giá tăng dần thành công!");
                    break;
                case 8:
                    System.out.print("Nhập mã sản phẩm cần bán: ");
                    String sellId = sc.nextLine();
                    for (int i = 0; i < productCount; i++) {
                        if (products[i] != null && products[i].getProductId().equals(sellId)) {
                            System.out.print("Nhập số lượng bán: ");
                            int sellQuantity = Integer.parseInt(sc.nextLine());
                            if (products[i].getQuantity() >= sellQuantity) {
                                products[i].setQuantity(products[i].getQuantity() - sellQuantity);
                                System.out.println("Bán sản phẩm thành công!");
                            } else {
                                System.out.println("Số lượng không đủ để bán!");
                            }
                            break;
                        }
                    }
                    break;
                case 9:
                    System.out.println("Thống kê số lượng sản phẩm theo danh mục:");
                    for (int i = 0; i < categoryCount; i++) {
                        if (categories[i] != null) {
                            int count = 0;
                            for (int j = 0; j < productCount; j++) {
                                if (products[j] != null && products[j].getCategoryId()==categories[i].getId()) {
                                    count++;
                                }
                            }
                            System.out.println(categories[i].getName() + ": " + count + " sản phẩm");
                        }
                    }
                    break;
                case 10:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        new ShopManagement().displayMainMenu();
    }
}