import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {
        String content = "Văn Lâm\nTiến Linh\nXuân Son\nHoàng Đức\nVăn Hậu";
        Path path = Paths.get("input.txt");
        try {
            Files.writeString(path, content);
            System.out.println("File input.txt đã được tạo thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi tạo file: " + e.getMessage());
        }
        try {
            List<String> lines = Files.readAllLines(path);
            String longestName = lines.stream()
                    .max((a, b) -> Integer.compare(a.length(), b.length()))
                    .orElse("");
            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên đó: " + longestName.length());
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}