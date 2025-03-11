import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài của chuỗi bạn muốn : ");
        int n = sc.nextInt();
        int typeText=0;
        StringBuilder result = new StringBuilder();
        if (1 <= n && n <= 1000) {
            for (int i = 1; i <= n; i++) {
                typeText = (int) (Math.random() * 3);
                char ch;
                if (typeText == 0) {
                    ch = (char) ('A' + (int) Math.floor(Math.random() * 26));
                }else if (typeText == 1) {
                    ch = (char) ('a' + (int) Math.floor(Math.random() * 26));
                }else {
                    ch = (char) ('0' + (int) Math.floor(Math.random() * 10));
                }
                result.append(ch);
            }

            System.out.println("Kết quả : "+result);
        }else{
            System.out.println("Số lượng chữ cái ko hợp lệ");
        }
    }
}
