import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Ex3 {
    public static void main(String[] args) {
        Path lines = null;
        try {
            String content = Files.readString(Paths.get("C:\\Users\\dungp\\Desktop\\java-IT109\\SS22\\input.txt"));
            lines = Files.writeString(Paths.get("copy.txt"), content);
            System.out.println("Đã sao chép nội dung thành công");
        } catch (IOException e) {
            System.err.println("Đã sảy ra lỗi: " + e.getMessage());
        }
        try {
            Files.readAllLines(lines);
            for (String line : Files.readAllLines(lines)) {
                System.out.println("Nội dung file copy: "+line);
            }
        } catch (IOException ex) {
            System.out.println("Đã sảy ra lỗi: " + ex.getMessage());
        }
    }
}
