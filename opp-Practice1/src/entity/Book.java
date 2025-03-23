package entity;
import java.util.Scanner;
import validator.Validator;

import java.util.Objects;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private int year;

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
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

    public Book(String bookId, String bookName, String author, float importPrice, float exportPrice, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest =exportPrice - importPrice;
        this.year = year;
    }
    @Override
    public boolean  equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return  bookId.equals(book.bookId) || Objects.equals(bookName, book.bookName);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }
    public void inputData(Scanner scanner){
        System.out.println("Nhập id");
        String newId=scanner.nextLine();
        Validator validator = new Validator();
        if(validator.validateId(newId)){
            bookId=newId;
        }
        System.out.println("Nhập tên");
        String newName=scanner.nextLine();
        if (validator.validateName(newName)){
            bookName=newName;
        }
        System.out.println("Nhập tên tác giả");
        String newAuthor=scanner.nextLine();
        if (validator.validateAuthor(newAuthor)){
            author=newAuthor;
        }
        int  newYear=Integer.parseInt(scanner.nextLine());
        if (validator.validateYear(newYear)){
            year=newYear;
        }
        inputPrice(scanner);
    }
    public void inputPrice(Scanner scanner){
        float newImportPrice = scanner.nextFloat();
        float newExportPrice = scanner.nextFloat();
        if (newImportPrice<=0){
            System.out.println("Giá nhập phải lớn hơn 0");
            return;
        };

        if (newImportPrice*1.3>newExportPrice){
            importPrice=newImportPrice;
            exportPrice=newExportPrice;
            return;
        }
        System.err.println("Giá nhập vào ko hợp lệ");

    }
}
