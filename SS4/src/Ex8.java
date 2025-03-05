import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một số nguyên dương N:");
        int N = sc.nextInt();

        if (N < 1) {
            System.out.println("Số nhập vào không hợp lệ. Vui lòng nhập số nguyên dương lớn hơn 0.");
            return;
        }
        System.out.println("Các số Armstrong từ 1 đến " + N + " là:");
        for (int i = 1; i <= N; i++) {
            int number = i;
            int sum = 0;
            int digits = String.valueOf(i).length();

            while (number > 0) {
                int digit = number % 10;
                sum += Math.pow(digit, digits);
                number /= 10;
            }

            if (sum == i) {
                System.out.print(i + " ");
            }
        }
    }
}
