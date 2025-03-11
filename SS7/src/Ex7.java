import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = sc.nextLine();
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z' && i != 0) {
                result.append("_");
            }
            result.append(ch);
        }

        System.out.println(result.toString().toLowerCase());
    }
}
