package ra.business;

import ra.entity.Book;
import ra.validate.BookValidate;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookBusiness {
    private Scanner scanner;

    public BookBusiness(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayAllBooks() {
        if (Book.getBooks().isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        Book.getBooks().forEach(Book::displayData);
    }

    public void addNewBooks() {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n <= 0) {
            System.out.println("Số lượng không hợp lệ!");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            new Book().inputData();
        }
        System.out.println("Thêm mới thành công!");
    }

    public void editBook() {
        System.out.print("Nhập mã sách cần sửa: ");
        String id = scanner.nextLine().trim();
        Book book = Book.getBooks().stream()
                .filter(b -> b.getBookId().equals(id))
                .findFirst().orElse(null);

        if (book == null) {
            System.out.println("Không tìm thấy sách!");
            return;
        }

        book.displayData();
        System.out.println("Chọn thuộc tính cần sửa:");
        System.out.println("1. Tiêu đề | 2. Tác giả | 3. NXB | 4. Năm XB | 5. Thể loại | 6. Giá | 7. Số lượng");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1: book.setBookTitle(BookValidate.inputBookTitle(scanner)); break;
            case 2: book.setAuthor(BookValidate.inputAuthor(scanner)); break;
            case 3: book.setPublisher(BookValidate.inputPublisher(scanner)); break;
            case 4: book.setPublicationYear(BookValidate.inputPublicationYear(scanner)); break;
            case 5: book.setCategory(BookValidate.inputCategory(scanner)); break;
            case 6: book.setPrice(BookValidate.inputPrice(scanner)); break;
            case 7: book.setQuantity(BookValidate.inputQuantity(scanner)); break;
            default: System.out.println("Lựa chọn không hợp lệ!"); return;
        }
        System.out.println("Cập nhật thành công!");
    }

    public void deleteBook() {
        System.out.print("Nhập mã sách cần xóa: ");
        String id = scanner.nextLine().trim();
        Book book = Book.getBooks().stream()
                .filter(b -> b.getBookId().equals(id))
                .findFirst().orElse(null);

        if (book == null) {
            System.out.println("Không tìm thấy sách!");
            return;
        }

        book.displayData();
        System.out.print("Bạn có chắc chắn muốn xóa? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            Book.getBooks().remove(book);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Hủy bỏ thao tác!");
        }
    }

    public void searchBook() {
        System.out.println("1. Tìm theo tiêu đề | 2. Tìm theo thể loại | 3. Tìm theo khoảng giá");
        int choice = Integer.parseInt(scanner.nextLine());
        List<Book> results;

        switch (choice) {
            case 1:
                System.out.print("Nhập tiêu đề cần tìm: ");
                String title = scanner.nextLine().trim();
                results = Book.getBooks().stream()
                        .filter(b -> b.getBookTitle().toLowerCase().contains(title.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case 2:
                System.out.print("Nhập thể loại cần tìm: ");
                String category = scanner.nextLine().trim();
                results = Book.getBooks().stream()
                        .filter(b -> b.getCategory().equalsIgnoreCase(category))
                        .collect(Collectors.toList());
                break;
            case 3:
                System.out.print("Nhập giá từ: ");
                double fromPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập giá đến: ");
                double toPrice = Double.parseDouble(scanner.nextLine());
                results = Book.getBooks().stream()
                        .filter(b -> b.getPrice() >= fromPrice && b.getPrice() <= toPrice)
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy kết quả phù hợp!");
        } else {
            results.forEach(Book::displayData);
        }
    }

    public void sortBooks() {
        System.out.println("1. Tiêu đề tăng dần | 2. Tiêu đề giảm dần | 3. Giá tăng dần | 4. Giá giảm dần");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Book.getBooks().sort(Comparator.comparing(Book::getBookTitle));
                break;
            case 2:
                Book.getBooks().sort(Comparator.comparing(Book::getBookTitle).reversed());
                break;
            case 3:
                Book.getBooks().sort(Comparator.comparing(Book::getPrice));
                break;
            case 4:
                Book.getBooks().sort(Comparator.comparing(Book::getPrice).reversed());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        System.out.println("Kết quả sắp xếp:");
        displayAllBooks();
    }
}