import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate initialDate = LocalDate.now();
        try {
            System.out.println("Nhập ngày");
            int initialDay = sc.nextInt();

            System.out.println("Nhập tháng");
            int initialMonth = sc.nextInt();

            System.out.println("Nhập năm");
            int initialYear = sc.nextInt();
            initialDate = LocalDate.of(initialYear, initialMonth, initialDay);
        } catch (Exception e) {
            System.out.println("Ngày tháng không hợp lệ!");
        }
        System.out.println("1.Tính ngày tiếp theo");
        System.out.println("2.Tính số ngày giữa 2 ngày");
        System.out.println("Nhập lựa chọn của bạn");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                nextDay(initialDate);
                break;
            case 2:
                caculateBeetweenTwoDay(initialDate);
                break;
            default:
                System.out.println("Lựa chọn ko hợp lệ");
                break;
        }
        sc.close();
    }

    public static void nextDay(LocalDate date) {
        LocalDate nextDate = date.plusDays(1);
        System.out.println("Ngày tiếp theo: " + nextDate);
    }

    public static void caculateBeetweenTwoDay(LocalDate date) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ngày");
        int newDay = sc.nextInt();
        System.out.println("Nhập tháng");
        int newMonth = sc.nextInt();
        System.out.println("Nhập năm");
        int newYear = sc.nextInt();
        LocalDate newDate = LocalDate.of(newYear, newMonth, newDay);
        long daysBetween = ChronoUnit.DAYS.between(date, newDate);
        if (daysBetween < 0) {daysBetween = -daysBetween;}
        System.out.println("Số ngày giữa 2 ngày đó là " + daysBetween);
    }
}
