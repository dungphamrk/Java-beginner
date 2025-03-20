import java.util.ArrayList;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        System.out.println("Nhập các số nguyên (nhập 0 để dừng):");
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) break;
            if (isPrime(num)) {
                primeNumbers.add(num);
            } else if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }
        System.out.println("Số nguyên tố: " + primeNumbers);
        System.out.println("Số chẵn (không phải số nguyên tố): " + evenNumbers);
        System.out.println("Số lẻ (không phải số nguyên tố): " + oddNumbers);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
