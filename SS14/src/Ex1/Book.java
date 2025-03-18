package Ex1;

import java.util.Scanner;

public class Book {
    private static int autoId=1;
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;
    public String getBookId() {
        return bookId;
    }
    private String generateBookId() {
        return String.format("B%04d", autoId++); // ID có dạng B0001, B0002, B0003...
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public void inputBookName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên sách (4 ký tự, bắt đầu bằng 'B'): ");
            bookName = scanner.nextLine().trim();
            if (bookName.matches("^B.{3}$")) break;
            System.out.println("Tên sách phải có 4 ký tự và bắt đầu bằng 'B'!");
        }
    }

    public void inputImportPrice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập giá nhập sách (>0): ");
                importPrice = Float.parseFloat(scanner.nextLine());
                if (importPrice > 0) break;
                System.out.println("Giá nhập phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public void inputExportPrice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập giá xuất sách (lớn hơn giá nhập ít nhất 30%): ");
                exportPrice = Float.parseFloat(scanner.nextLine());
                if (exportPrice >= importPrice * 1.3) break;
                System.out.println("Giá xuất phải cao hơn ít nhất 30% so với giá nhập!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public void inputAuthor(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên tác giả (6-50 ký tự): ");
            author = scanner.nextLine().trim();
            if (author.length() >= 6 && author.length() <= 50) break;
            System.out.println("Tên tác giả phải từ 6-50 ký tự!");
        }
    }

    public void inputYear(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập năm xuất bản (>2000): ");
                year = Integer.parseInt(scanner.nextLine());
                if (year > 2000) break;
                System.out.println("Năm xuất bản phải lớn hơn 2000!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    // Phương thức nhập tất cả thông tin sách
    public void inputBook(Scanner scanner) {
        inputBookName(scanner);
        inputImportPrice(scanner);
        inputExportPrice(scanner);
        inputAuthor(scanner);
        inputYear(scanner);
        calculateInterest();
    }

    // Phương thức hiển thị thông tin sách
    public void displayBook() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("------------------------");
    }


}
