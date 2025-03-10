import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một chuỗi bất kì : ");
        String str = sc.nextLine().trim();
        String replaceStr = str.replaceAll("[0-9]", "*");
        System.out.println(replaceStr);
    }
}
