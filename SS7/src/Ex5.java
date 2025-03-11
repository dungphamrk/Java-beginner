import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine();
        input = input.trim().replaceAll("\\s+", " ").toLowerCase();
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length-1; i >= 0; i-- ) {
            result.append(words[i]).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}
