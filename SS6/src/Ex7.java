import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi email để kiểm tra: ");
        String strEmail = sc.nextLine().trim();

        String regex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strEmail);

        if (matcher.find()) {
            String[] separation = strEmail.split("@");
            String userName = separation[0];
            String domain = separation[1];
            System.out.println("Tên người dùng : "+userName+", Tên miền : "+domain+"");
        }else {
            System.out.println("Email ko hợp lệ");
        }
    }
}
