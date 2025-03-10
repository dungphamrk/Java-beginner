import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại : ");
        String strPhone = sc.nextLine().trim();
        strPhone = strPhone.replaceAll("[-.]", " ").trim();
        if (strPhone.startsWith("0")) {
            strPhone = strPhone.replaceFirst("0", "+84");
        }
        strPhone = strPhone.replaceAll("\\s+", " ");
        String regex = "(\\+84\\d{9}|0\\d{9})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strPhone);
        if (matcher.matches()) {
            System.out.println("Số điện thoại hợp lệ: " + strPhone);
        } else {
            System.out.println("Số điện thoại không hợp lệ: " + strPhone);
        }
    }
}
