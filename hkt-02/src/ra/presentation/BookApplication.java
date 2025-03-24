package ra.presentation;

import ra.business.BookBusiness;
import ra.entity.Book;

import java.util.Scanner;

public class BookApplication {
    private static final int MAX_BOOKS = 100;
    private static Book[] listBook = new Book[MAX_BOOKS];
    private static int currentSize = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookBusiness business = new BookBusiness(scanner);

        while (true) {
            displayMenu();
            System.out.print("Chọn chức năng (0-6): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    business.displayAllBooks(listBook, currentSize);
                    break;
                case 2:
                    currentSize = business.addNewBooks(listBook, currentSize, MAX_BOOKS);
                    break;
                case 3:
                    currentSize = business.editBook(listBook, currentSize);
                    break;
                case 4:
                    currentSize = business.deleteBook(listBook, currentSize);
                    break;
                case 5:
                    business.searchBook(listBook, currentSize);
                    break;
                case 6:
                    business.sortBooks(listBook, currentSize);
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