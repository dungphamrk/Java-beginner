import java.io.File;
import java.io.IOException;
public class Ex2 {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("data.txt");
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Tệp đã đươc tạo: " +file.getName());
                }
            } else {
                System.out.println("Tệp đã tồn tại");
            }
        } catch (IOException e) {
            System.err.println("Đã sảy ra lỗi: " + e.getMessage());
        }
    }
}
