import java.util.Scanner;
import java.util.regex.Pattern;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, double importPrice, double exportPrice,
                double interest, String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getInterest() {
        return exportPrice - importPrice;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void inputData(Scanner sc) {
        System.out.print("Nhập vào mã sách : ");
        while (true) {
            this.bookId = sc.nextLine();
            if (Pattern.matches("B\\d{4}", this.bookId)) {
                break;
            }
            System.err.println("Mã sách không hợp lệ! Vui lòng nhập lại.");
        }

        System.out.print("Nhập vào tên sách : ");
        while (true) {
            this.bookName = sc.nextLine().trim();
            if (bookName.length() >= 6 && bookName.length() <= 100) {
                break;
            }
            System.err.println("Tên sách không hợp lệ! Vui lòng nhập lại.");
        }

        while (true) {
            System.out.print("Nhập vào giá nhập: ");
            this.importPrice = Double.parseDouble(sc.nextLine());
            if (importPrice > 0) break;
            System.err.println("Giá trị phải lớn hơn 0! Vui lòng nhập lại.");
        }

        while (true) {
            System.out.print("Nhập vào giá bán: ");
            this.exportPrice = Double.parseDouble(sc.nextLine());
            if (exportPrice > importPrice * 1.1) break;
            System.err.println("Giá bán phải lớn hơn ít nhất 10% so với giá nhập! Vui lòng nhập lại.");
        }

        System.out.print("Nhập vào tiêu đề sách: ");
        while ((this.title = sc.nextLine().trim()).isEmpty()) {
            System.err.println("Trường này không được để trống! Vui lòng nhập lại.");
        }

        System.out.print("Nhập vào tác giả: ");
        while ((this.author = sc.nextLine().trim()).isEmpty()) {
            System.err.println("Trường này không được để trống! Vui lòng nhập lại.");
        }

        while (true) {
            System.out.print("Nhập vào năm xuất bản (Sau 1970): ");
            this.year = Integer.parseInt(sc.nextLine());
            if (year > 1970) break;
            System.err.println("Năm xuất bản phải sau 1970! Vui lòng nhập lại.");
        }
    }

    public void displayData() {
        System.out.printf("Mã sách: %s , Tên sách: %s, Giá nhập: %.2f, Giá bán: %.2f%n", bookId, bookName, importPrice, exportPrice);
        System.out.printf("Tiêu đề: %s, Tác giả: %s , Lợi nhuận: %.2f , Năm XB: %d%n", title, author, getInterest(), year);
    }

    @Override
    public String toString() {
        return String.format(
                "Mã sách: %s%nTên sách: %s%nTác giả: %s%nGiá nhập: %.2f%nGiá bán: " +
                        "%.2f%nLợi nhuận: %.2f%n",
                bookId, bookName, author, importPrice, exportPrice, getInterest()
        );
    }
}
