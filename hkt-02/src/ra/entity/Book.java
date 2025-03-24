package ra.entity;

import ra.validate.BookValidate;

import java.util.Scanner;

public class Book implements IApp {
    private String bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;
    private static int bookCounter = 1;

    public Book() {
        this.bookId = "B" + String.format("%05d", bookCounter++);
    }

    public Book(String bookTitle, String author, String publisher, int publicationYear, String category, double price, int quantity) {
        this();
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        this.bookTitle = BookValidate.inputBookTitle(scanner);
        this.author = BookValidate.inputAuthor(scanner);
        this.publisher = BookValidate.inputPublisher(scanner);
        this.publicationYear = BookValidate.inputPublicationYear(scanner);
        this.category = BookValidate.inputCategory(scanner);
        this.price = BookValidate.inputPrice(scanner);
        this.quantity = BookValidate.inputQuantity(scanner);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %s | Tiêu đề: %s | Tác giả: %s | NXB: %s | Năm XB: %d | Thể loại: %s | Giá: %.2f | Số lượng: %d\n",
                bookId, bookTitle, author, publisher, publicationYear, category, price, quantity);
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}