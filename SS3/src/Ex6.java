import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một số nguyên từ 1 đến 12: ");
        int month = sc.nextInt();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng 1 có 31 ngày.");
                break;
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng 4 có 30 ngày.");
                break;
            default:
                System.out.println("Tháng không hợp lệ.");
        }
    }
}
