import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập một chuỗi bất kỳ:");
        String input = sc.nextLine();

        String[] words = input.trim().split("\\s+");

        int wordCount = input.trim().isEmpty() ? 0 : words.length;
        
        System.out.println("Số từ trong chuỗi: " + wordCount);
        sc.close();
    }
}
