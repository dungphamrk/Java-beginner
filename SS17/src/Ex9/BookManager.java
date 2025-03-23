package Ex9;

import java.util.*;

public class BookManager {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("1", "Java Programming", "Author A", 2015));
        bookSet.add(new Book("1", "Data Structures", "Author B", 2018));
        bookSet.add(new Book("3", "Algorithms", "Author C", 2020));
        bookSet.add(new Book("4", "Database Systems", "Author D", 2016));

        List<Book> filteredBooks = new ArrayList<>(bookSet);
        Collections.sort(filteredBooks, Comparator.comparing(Book::getTitle));
        System.out.println("Danh sách sách sau khi lọc và sắp xếp:");
        for (Book book : filteredBooks) {
            System.out.println(book);
        }
    }
}
