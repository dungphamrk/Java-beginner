package ra.validate;

import java.util.Scanner;

public class BookValidate {
    public static String inputBookTitle(Scanner scanner) {
        String title;
        do {
            System.out.print("Nhập tiêu đề sách (tối đa 100 ký tự, không để trống): ");
            title = scanner.nextLine().trim();
            if (title.isEmpty() || title.length() > 100) {
                System.out.println("Tiêu đề không hợp lệ!");
            }
        } while (title.isEmpty() || title.length() > 100);
        return title;
    }

    public static String inputAuthor(Scanner scanner) {
        String author;
        do {
            System.out.print("Nhập tác giả (tối đa 50 ký tự, không để trống): ");
            author = scanner.nextLine().trim();
            if (author.isEmpty() || author.length() > 50) {
                System.out.println("Tác giả không hợp lệ!");
            }
        } while (author.isEmpty() || author.length() > 50);
        return author;
    }

    public static String inputPublisher(Scanner scanner) {
        String publisher;
        do {
            System.out.print("Nhập nhà xuất bản (tối đa 100 ký tự, không để trống): ");
            publisher = scanner.nextLine().trim();
            if (publisher.isEmpty() || publisher.length() > 100) {
                System.out.println("Nhà xuất bản không hợp lệ!");
            }
        } while (publisher.isEmpty() || publisher.length() > 100);
        return publisher;
    }

    public static int inputPublicationYear(Scanner scanner) {
        int year;
        do {
            System.out.print("Nhập năm xuất bản: ");
            year = Integer.parseInt(scanner.nextLine().trim());
            if (year <= 0) {
                System.out.println("Năm xuất bản phải lớn hơn 0!");
            }
        } while (year <= 0);
        return year;
    }

    public static String inputCategory(Scanner scanner) {
        String category;
        do {
            System.out.print("Nhập thể loại (tối đa 100 ký tự, không để trống): ");
            category = scanner.nextLine().trim();
            if (category.isEmpty() || category.length() > 100) {
                System.out.println("Thể loại không hợp lệ!");
            }
        } while (category.isEmpty() || category.length() > 100);
        return category;
    }

    public static double inputPrice(Scanner scanner) {
        double price;
        do {
            System.out.print("Nhập giá sách (> 0): ");
            price = Double.parseDouble(scanner.nextLine().trim());
            if (price <= 0) {
                System.out.println("Giá phải lớn hơn 0!");
            }
        } while (price <= 0);
        return price;
    }

    public static int inputQuantity(Scanner scanner) {
        int quantity;
        do {
            System.out.print("Nhập số lượng (> 0): ");
            quantity = Integer.parseInt(scanner.nextLine().trim());
            if (quantity <= 0) {
                System.out.println("Số lượng phải lớn hơn 0!");
            }
        } while (quantity <= 0);
        return quantity;
    }
}