package run;

import entity.Book;
import run.BookManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookImp {
    public static List<Book> listBook= new ArrayList<>();

    public static void main(String[] args) {
        bookMenu();
    }
    public static void bookMenu(){
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận ận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận ận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập ập từ bàn phím)");
            System.out.println("7. Thống kê số lượnợng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượnợng sách theo tác giả");
            System.out.println("9. Thoát");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    BookManager.addBook(scanner);
                    break;
                case 2:
                    BookManager.bookProfit(scanner);
                    break;
                case 3:
                    BookManager.displayBooks();
                    break;
                case 4:
                    BookManager.sortBooksByPrice();
                    break;
                case 5:
                    BookManager.sortBooksByProfit();
                    break;
                case 6:
                    BookManager.searchBookByName(scanner);
                    break;
                case 7:
                    BookManager.statisticByYear();
                    break;
                case 8:
                    BookManager.statisticByAuthor();
                    break;
                case 9:
                    return;
                default:
                    break;
            }
        }while(true);
    }
}
