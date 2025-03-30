import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex6 {
    public static void main(String[] args) {
        String content = "Luyện tập kỹ năng đọc và ghi file văn bản trong Java";
        try {
            Files.writeString(Paths.get("input.txt"), content);
            System.out.println("File input.txt đã được tạo thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi tạo file: " + e.getMessage());
        }
        String reverseStr = new StringBuilder(content).reverse().toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(reverseStr);
            System.out.println("Đã ghi vào file output.txt");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }
    }
}