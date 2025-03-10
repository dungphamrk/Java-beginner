import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào một đoạn văn bản:");
        String input = sc.nextLine();

        String[] words = input.split(" ");
        int count = 0;

        System.out.println("Các từ chứa ký tự đặc biệt:");

        for (String word : words) {
            if (word.matches(".*[^a-zA-Z0-9].*")) {
                System.out.println(word);
                count++;
            }
        }

        System.out.println("Số lượng từ chứa ký tự đặc biệt: " + count);

    }
}
