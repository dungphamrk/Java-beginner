import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=0;
        System.out.print("Nhập số phần tử của mảng: ");
        n=sc.nextInt();
        int [] arr = new int[n];
        int sum=0;
        System.out.println("Nhập lần lượt từng phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        System.out.println("Tổng của các phần tử đó là "+ sum);
    }
}
