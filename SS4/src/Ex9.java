import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean found = false;
        if (n > 0) {
            System.out.println("Các số Palindrome nhỏ hơn hoặc bằng " + n + " là: ");
            for (int i = 1; i <= n; i++) {
                int initial = i;
                int reversed = 0;
                int temp = i;

                while (temp > 0) {
                    initial = initial * 10 + temp % 10;
                    temp /= 10;
                }

                if (initial == reversed) {
                    System.out.print(i + ", ");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Ko có số Palindrome nào");
            }
        }else  {
            System.out.println("Số nhập vào không hợp lệ");
        }
    }
}
