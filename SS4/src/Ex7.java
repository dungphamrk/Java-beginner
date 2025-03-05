import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên dương N:");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Số nhập vào không hợp lệ. Vui lòng nhập một số nguyên dương lớn hơn 0.");
            return;
        }

        System.out.println("Các số Happy từ 1 đến " + n + " là:");
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                int temp = i, sum = 0;

                while (temp != 1 && temp != 4) {
                    sum = 0;
                    int num = temp;

                    while (num != 0) {
                        int digit = num % 10;
                        sum += digit * digit;
                        num /= 10;
                    }
                    temp = sum;
                }
                if (temp == 1) {
                    System.out.print(i + ", ");
                }
            }
        } else {
            System.out.println("Số nhập vào không hợp lệ");
        }
    }

}
