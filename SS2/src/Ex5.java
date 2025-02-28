import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều dài và chiều rộng của 1 hình chữ nhật");
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Diện tích của hình chữ nhật là: "+area(r,c));
        System.out.println("Chu vi của hình chữ nhật là: "+perimeter(r,c));
    }
    public static int area(int r, int c) {
        return r*c;
    }
    public static int perimeter(int r, int c) {
        return 2*(r+c);
    }
}
