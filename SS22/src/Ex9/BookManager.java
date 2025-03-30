package Ex9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    Scanner scanner = new Scanner(System.in);
    public List<Book> books = new ArrayList<>();
    public void addBook(Book book) {
        books.add(book);
    }
    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return;
            }
        }
    }
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }


}