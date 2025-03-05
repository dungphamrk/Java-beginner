import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tìm và tính tổng các ước của số");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thoát chương trình.");
                break;
            }

            System.out.print("Nhập một số nguyên dương: ");
            int n = sc.nextInt();

            if (choice == 1) { // Kiểm tra số nguyên tố
                boolean isPrime = true;
                if (n < 2) {
                    isPrime = false;
                } else {
                    for (int i = 2; i <= Math.sqrt(n); i++) {
                        if (n % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                if (isPrime) {
                    System.out.println(n + " là số nguyên tố.");
                } else {
                    System.out.println(n + " không phải là số nguyên tố.");
                }

            } else if (choice == 2) { // Kiểm tra số hoàn hảo
                int sum = 0;
                for (int i = 1; i < n; i++) {
                    if (n % i == 0) {
                        sum += i;
                    }
                }
                if (sum == n) {
                    System.out.println(n + " là số hoàn hảo.");
                } else {
                    System.out.println(n + " không phải là số hoàn hảo.");
                }

            } else if (choice == 3) { // Tính tổng các ước của số
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    if (n % i == 0) {
                        sum += i;
                    }
                }
                System.out.println("Tổng các ước của " + n + " là: " + sum);

            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        sc.close();
    }
}