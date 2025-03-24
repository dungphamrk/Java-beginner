package ra.business;

import ra.entity.Book;
import ra.validate.BookValidate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BookBusiness {
    private Scanner scanner;

    public BookBusiness(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayAllBooks(Book[] listBook, int currentSize) {
        if (currentSize == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            listBook[i].displayData();
        }
    }

    public int addNewBooks(Book[] listBook, int currentSize, int maxSize) {
        if (currentSize >= maxSize) {
            System.out.println("Danh sách đã đầy, không thể thêm mới!");
            return currentSize;
        }
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n <= 0 || currentSize + n > maxSize) {
            System.out.println("Số lượng không hợp lệ hoặc vượt quá giới hạn!");
            return currentSize;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            Book book = new Book();
            book.inputData();
            listBook[currentSize + i] = book;
        }
        System.out.println("Thêm mới thành công!");
        return currentSize + n;
    }

    public int editBook(Book[] listBook, int currentSize) {
        System.out.print("Nhập mã sách cần sửa: ");
        String id = scanner.nextLine().trim();
        int index = findBookIndex(listBook, currentSize, id);

        if (index == -1) {
            System.out.println("Không tìm thấy sách!");
            return currentSize;
        }

        listBook[index].displayData();
        System.out.println("Chọn thuộc tính cần sửa:");
        System.out.println("1. Tiêu đề | 2. Tác giả | 3. NXB | 4. Năm XB | 5. Thể loại | 6. Giá | 7. Số lượng");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1: listBook[index].setBookTitle(BookValidate.inputBookTitle(scanner)); break;
            case 2: listBook[index].setAuthor(BookValidate.inputAuthor(scanner)); break;
            case 3: listBook[index].setPublisher(BookValidate.inputPublisher(scanner)); break;
            case 4: listBook[index].setPublicationYear(BookValidate.inputPublicationYear(scanner)); break;
            case 5: listBook[index].setCategory(BookValidate.inputCategory(scanner)); break;
            case 6: listBook[index].setPrice(BookValidate.inputPrice(scanner)); break;
            case 7: listBook[index].setQuantity(BookValidate.inputQuantity(scanner)); break;
            default: System.out.println("Lựa chọn không hợp lệ!"); return currentSize;
        }
        System.out.println("Cập nhật thành công!");
        return currentSize;
    }

    public int deleteBook(Book[] listBook, int currentSize) {
        System.out.print("Nhập mã sách cần xóa: ");
        String id = scanner.nextLine().trim();
        int index = findBookIndex(listBook, currentSize, id);

        if (index == -1) {
            System.out.println("Không tìm thấy sách!");
            return currentSize;
        }

        listBook[index].displayData();
        System.out.print("Bạn có chắc chắn muốn xóa? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            for (int i = index; i < currentSize - 1; i++) {
                listBook[i] = listBook[i + 1];
            }
            listBook[currentSize - 1] = null;
            System.out.println("Xóa thành công!");
            return currentSize - 1;
        } else {
            System.out.println("Hủy bỏ thao tác!");
            return currentSize;
        }
    }

    public void searchBook(Book[] listBook, int currentSize) {
        System.out.println("1. Tìm theo tiêu đề | 2. Tìm theo thể loại | 3. Tìm theo khoảng giá");
        int choice = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        switch (choice) {
            case 1:
                System.out.print("Nhập tiêu đề cần tìm: ");
                String title = scanner.nextLine().trim();
                for (int i = 0; i < currentSize; i++) {
                    if (listBook[i].getBookTitle().toLowerCase().contains(title.toLowerCase())) {
                        listBook[i].displayData();
                        found = true;
                    }
                }
                break;
            case 2:
                System.out.print("Nhập thể loại cần tìm: ");
                String category = scanner.nextLine().trim();
                for (int i = 0; i < currentSize; i++) {
                    if (listBook[i].getCategory().equalsIgnoreCase(category)) {
                        listBook[i].displayData();
                        found = true;
                    }
                }
                break;
            case 3:
                System.out.print("Nhập giá từ: ");
                double fromPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập giá đến: ");
                double toPrice = Double.parseDouble(scanner.nextLine());
                for (int i = 0; i < currentSize; i++) {
                    if (listBook[i].getPrice() >= fromPrice && listBook[i].getPrice() <= toPrice) {
                        listBook[i].displayData();
                        found = true;
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (!found) {
            System.out.println("Không tìm thấy kết quả phù hợp!");
        }
    }

    public void sortBooks(Book[] listBook, int currentSize) {
        System.out.println("1. Tiêu đề tăng dần | 2. Tiêu đề giảm dần | 3. Giá tăng dần | 4. Giá giảm dần");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Arrays.sort(listBook, 0, currentSize, Comparator.comparing(Book::getBookTitle));
                break;
            case 2:
                Arrays.sort(listBook, 0, currentSize, Comparator.comparing(Book::getBookTitle).reversed());
                break;
            case 3:
                Arrays.sort(listBook, 0, currentSize, Comparator.comparing(Book::getPrice));
                break;
            case 4:
                Arrays.sort(listBook, 0, currentSize, Comparator.comparing(Book::getPrice).reversed());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        System.out.println("Kết quả sắp xếp:");
        displayAllBooks(listBook, currentSize);
    }

    private int findBookIndex(Book[] listBook, int currentSize, String id) {
        for (int i = 0; i < currentSize; i++) {
            if (listBook[i].getBookId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}