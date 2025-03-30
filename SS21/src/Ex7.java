import java.util.Scanner;

public class Ex7 {
    public static double balance = 222222;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhập số tiền muốn rút: ");
            int amount = Integer.parseInt(scanner.nextLine());
            withdrawals (amount);
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Vui lòng nhập một số hợp lệ");
        }
    }
    public static void withdrawals (int amount) {
        if (amount > balance) {
            try {
                throw new Exception("Lỗi: Số tiền rút vượt quá số dư!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (balance < 50000) {
            try {
                throw new Exception("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            balance -= amount;
            System.out.println("Rút tiền thành công ");
        }
    }
}
