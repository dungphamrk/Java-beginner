package ra.imp;

import ra.entity.ProductManager;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager(scanner);

        while (true) {
            displayMenu();
            System.out.print("Chọn chức năng (1-10): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.inputMultipleProducts();
                    break;
                case 2:
                    manager.displayAllProducts();
                    break;
                case 3:
                    manager.calculateAllProfits();
                    break;
                case 4:
                    manager.sortByProfit();
                    break;
                case 5:
                    manager.statisticByPriceRange();
                    break;
                case 6:
                    manager.searchByName();
                    break;
                case 7:
                    manager.importProduct();
                    break;
                case 8:
                    manager.sellProduct();
                    break;
                case 9:
                    manager.updateStatus();
                    break;
                case 10:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("***********************MENU**************************");
        System.out.println("1. Nhập thông tin n sản phẩm");
        System.out.println("2. Hiển thị thông tin các sản phẩm");
        System.out.println("3. Tính lợi nhuận các sản phẩm");
        System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
        System.out.println("5. Thống kê các sản phẩm theo giá");
        System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
        System.out.println("7. Nhập sản phẩm");
        System.out.println("8. Bán sản phẩm");
        System.out.println("9. Cập nhật trạng thái sản phẩm");
        System.out.println("10. Thoát");
    }
}