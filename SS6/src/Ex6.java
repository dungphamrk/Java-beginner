import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập một mật khẩu bất kì : ");
        String str = sc.nextLine().trim();
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%])[A-Za-z0-9@#$!%]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if(matcher.find()){
            System.out.println("Mật khẩu hợp lệ");
        }else{
            System.out.println("Mật khẩu ko hợp lệ");
        }

    }
}
