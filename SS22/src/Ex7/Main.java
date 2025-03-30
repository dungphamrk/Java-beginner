package Ex7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> listCountry = new ArrayList<>();
        listCountry.add(new Country(1, "AU", "Australia"));
        listCountry.add(new Country(2, "CN", "China"));
        listCountry.add(new Country(3, "AU", "Australia"));
        listCountry.add(new Country(4, "CN", "China"));
        listCountry.add(new Country(5, "JP", "Japan"));
        listCountry.add(new Country(6, "CN", "China"));
        listCountry.add(new Country(7, "JP", "Japan"));
        listCountry.add(new Country(8, "TH", "Thailand"));

        writeToFile(listCountry);
        readFromFile();
    }
    public static void writeToFile(List<Country> listCountry) {
        File file = new File("data.txt");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listCountry);
            oos.flush();
            System.out.println("Đã ghi danh sách quốc gia vào file data.txt");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public static void readFromFile() {
        File file = new File("data.txt");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Country> listCountry = (List<Country>) ois.readObject();
            System.out.println("Danh sách quốc gia đọc từ file:");
            listCountry.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}