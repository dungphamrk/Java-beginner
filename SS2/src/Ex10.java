import java.math.BigInteger;
import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên lớn a: ");
        String num1 = sc.nextLine();
        System.out.print("Nhập số nguyên lớn b: ");
        String num2 = sc.nextLine();

        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);

        System.out.println("Tổng: " + a.add(b).toString());
        System.out.println("Hiệu: " + a.subtract(b).toString());
        System.out.println("Tích: " + a.multiply(b).toString());
        if (!b.equals(BigInteger.ZERO)) {
            System.out.println("Thương: " + a.divide(b).toString());
            System.out.println("Số dư: " + a.mod(b).toString());
        } else {
            System.out.println("Không thể chia cho 0.");
        }

        System.out.println("Lũy thừa bậc 10 của số thứ nhất: " + a.pow(10).toString());
        sc.close();
    }
}
