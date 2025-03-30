import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào độ tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        checkAge(age);
    }
    public static void checkAge(int age) {
        if (age < 18) {
            try {
                throw new Exception("Bạn chưa đủ 18 tuổi!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Chào mừng bạn");
        }
    }
}
