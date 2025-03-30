package Ex8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop Asus", 1500000));
        products.add(new Product(102, "Chuột Logitech", 500000));
        products.add(new Product(103, "Bàn phím", 320000));
        products.add(new Product(104, "Laptop Dell", 2000000));
        products.add(new Product(105, "Tai nghe", 600000));
        writeToFile(products);
        readFromFile();
    }

    public static void writeToFile(List<Product> products) {
        File file = new File("products.dat");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
            oos.flush();
            System.out.println("Đã ghi danh sách sản phẩm vào file products.dat");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static void readFromFile() {
        File file = new File("products.dat");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Product> products = (List<Product>) ois.readObject();
            System.out.println("Danh sách sản phẩm đọc từ file:");
            products.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
