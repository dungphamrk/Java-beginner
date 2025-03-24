package ra.presentation;

import ra.business.BookBusiness;

import java.util.Scanner;

public class BookApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookBusiness business = new BookBusiness(scanner);

        while (true) {
            displayMenu();
            System.out.print("Chọn chức năng (0-6): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    business.displayAllBooks();
                    break;
                case 2:
                    business.addNewBooks();
                    break;
                case 3:
                    business.editBook();
                    break;
                case 4:
                    business.deleteBook();
                    break;
                case 5:
                    business.searchBook();
                    break;
                case 6:
                    business.sortBooks();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("----------------------------Book Menu----------------------------");
        System.out.println("1. Hiển thị danh sách các cuốn sách");
        System.out.println("2. Thêm mới sách");
        System.out.println("3. Chỉnh sửa thông tin sách");
        System.out.println("4. Xóa sách");
        System.out.println("5. Tìm kiếm sách");
        System.out.println("6. Sắp xếp");
        System.out.println("0. Thoát chương trình");
        System.out.println("------------------------------------------------------------------");
    }
}