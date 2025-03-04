import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số đầu tiên: ");
        double num1 = sc.nextDouble();

        System.out.print("Nhập toán tử cần thực hiện: ");
        char operator = sc.next().charAt(0);

        System.out.print("Nhập số thứ hai: ");
        double num2 = sc.nextDouble();

        switch (operator) {
            case '+':
                System.out.println("Kết quả: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Kết quả: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Kết quả: " + (num1 * num2));
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Không thể chia cho 0.");
                } else {
                    System.out.println("Kết quả: " + (num1 / num2));
                }
                break;
            default:
                System.out.println("Phép toán không hợp lệ.");
        }
    }
}
