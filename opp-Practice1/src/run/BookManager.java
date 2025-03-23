package run;

import entity.Book;

import java.util.Comparator;
import java.util.Scanner;

public class BookManager {
    public static void addBook (Scanner scanner ){
        System.out.println("Nhập số lượng sâch muốn thêm vào");
        int n= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Book newBook = new Book();
            newBook.inputData(scanner);
            BookImp.listBook.add(newBook);
        }
    }
    public static void bookProfit(Scanner  scanner){
        System.out.print("Nhập ID sách cần tính lợi nhuận: ");
        String findId = scanner.nextLine();
        for (Book book : BookImp.listBook) {
            if (book.getBookId().equalsIgnoreCase(findId)) {
                System.out.printf("Lợi nhuận của sách %s là: %.2f\n", book.getBookName(), book.getInterest());
                return;
            }
        }
        System.out.println("Không tìm thấy sách!");
    }
    public static void displayBooks() {
        if (BookImp.listBook.isEmpty()) {
            System.out.println("Danh sách sách trống!");
        } else {
            System.out.println("Danh sách sách:");
            for (Book book : BookImp.listBook) {
                System.out.println(book);
            }
        }
    }

    public static void sortBooksByPrice() {
        BookImp.listBook.sort(Comparator.comparingDouble(Book::getExportPrice).reversed());
        System.out.println("Sắp xếp sách theo giá bán giảm dần:");
        displayBooks();
    }

    public static void sortBooksByProfit() {
        BookImp.listBook.sort(Comparator.comparingDouble(Book::getInterest).reversed());
        System.out.println("Sắp xếp sách theo lợi nhuận giảm dần:");
        displayBooks();
    }

    public static void searchBookByName(Scanner scanner) {
        System.out.print("Nhập tên sách cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Book book : BookImp.listBook) {
            if (book.getBookName().toLowerCase().contains(name)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách!");
        }
    }
    public static void statisticByYear() {
        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
        for (int i = 0; i < BookImp.listBook.size(); i++) {
            int count = 0;
            int year = BookImp.listBook.get(i).getYear();
            boolean isCounted = false;

            for (int j = 0; j < i; j++) {
                if (BookImp.listBook.get(j).getYear() == year) {
                    isCounted = true;
                    break;
                }
            }

            if (!isCounted) {
                for (Book book : BookImp.listBook) {
                    if (book.getYear() == year) {
                        count++;
                    }
                }
                System.out.println("Năm " + year + ": " + count + " sách");
            }
        }
    }

    public static void statisticByAuthor() {
        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (int i = 0; i < BookImp.listBook.size(); i++) {
            int count = 0;
            String author = BookImp.listBook.get(i).getAuthor();
            boolean isCounted = false;
            for (int j = 0; j < i; j++) {
                if (BookImp.listBook.get(j).getAuthor().equalsIgnoreCase(author)) {
                    isCounted = true;
                    break;
                }
            }
            if (!isCounted) {
                for (Book book : BookImp.listBook) {
                    if (book.getAuthor().equalsIgnoreCase(author)) {
                        count++;
                    }
                }
                System.out.println(author + ": " + count + " sách");
            }
        }
    }
}
