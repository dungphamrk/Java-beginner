import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập số nguyên bất kì: ");
            int number = Integer.parseInt(scanner.nextLine());
            isPrime(number);
        } catch (NumberFormatException e1) {
            System.err.println("Vui lòng nhập một giá trị số nguyên");
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
        }
    }
    public static void isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println(number + " không phải là số nguyên tố");
                return;
            }
        }
        System.out.println(number + " là số nguyên tố.");
    }
}
