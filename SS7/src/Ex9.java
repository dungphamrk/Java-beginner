import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi : ");
        String str = sc.nextLine();
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            }else {
                result.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        System.out.println("Kết quả: "+result);
    }
}
