import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi văn bản bất kỳ: ");
        String strText = scanner.nextLine().trim();

        if (strText.isEmpty()) {
            System.out.println("Không có văn bản để xử lý.");
            return;
        }
        strText = strText.toLowerCase();
        strText = strText.replaceAll("[^a-z0-9\s]", "");
        strText = strText.replaceAll("\\s+", " ").trim();

        System.out.println("Văn bản đã được xử lý: " + strText);

        String letters = "";
        String numbers = "";

        for (String word : strText.split(" ")) {
            if (word.matches("\\d+")) {
                if (!numbers.isEmpty()) {
                    numbers += " ";
                }
                numbers += word;
            } else {
                if (!letters.isEmpty()) {
                    letters += " ";
                }
                letters += word;
            }
        }
        System.out.println("Các chữ cái tìm thấy: " + letters);
        System.out.println("Các số tìm thấy: " + numbers);
    }
}
