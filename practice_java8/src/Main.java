import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện");
            System.out.println("7. Sắp xếp sản phẩm theo giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> ProductBusiness.listProducts();
                case 2 -> ProductBusiness.addProduct(scanner);
                case 3 -> ProductBusiness.updateProduct(scanner);
                case 4 -> ProductBusiness.deleteProductById(scanner);
                case 5 -> ProductBusiness.searchProductByName(scanner);
                case 6 -> ProductBusiness.filterProducts(scanner);
                case 7 -> ProductBusiness.sortProducts(scanner);
                case 8 -> System.exit(0);
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (true);
    }



}
