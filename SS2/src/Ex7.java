import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập số giờ ban đầu: ");
        int initialHour = sc.nextInt();
        System.out.println("Nhập số phút ban đầu: ");
        int initialMinute = sc.nextInt();
        System.out.println("Nhập số giây ban đầu: ");
        int initialSecond = sc.nextInt();

        System.out.println("Nhập số giờ cần cộng: ");
        int addHour = sc.nextInt();
        System.out.println("Nhập số phút cần cộng: ");
        int addMinute = sc.nextInt();
        System.out.println("Nhập số giây cần cộng: ");
        int addSecond = sc.nextInt();

        int totalInitialSeconds = initialHour * 3600 + initialMinute * 60 + initialSecond;
        int totalAddSeconds = addHour * 3600 + addMinute * 60 + addSecond;

        int totalSeconds = totalInitialSeconds + totalAddSeconds;

        int finalHour = totalSeconds / 3600;
        totalSeconds %= 3600;
        int finalMinute = totalSeconds / 60;
        int finalSecond = totalSeconds % 60;

        System.out.println("Thời gian sau khi cộng: " + finalHour + " giờ, " + finalMinute + " phút, " + finalSecond + " giây");
    }
}
