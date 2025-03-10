import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập URL bất kì để trích xuất : ");
        String url = sc.nextLine().trim();

        String regex = ("^(https?://)([a-zA-Z0-9.-]+)(/.*)?$");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if(matcher.find()){
            String protocol = matcher.group(1);
            String domain = matcher.group(2);
            String path = matcher.group(3);

            System.out.println("Giao thức: "+protocol+", Tên miền: "+domain+", Đường dẫn: "+(path != null ? path : "Không có đường dẫn")+"");
        }else {
            System.out.println("URL ko hợp lệ");
        }
    }
}
