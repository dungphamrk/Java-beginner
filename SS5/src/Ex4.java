import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=0;
        System.out.print("Nhập số phần tử của mảng: ");
        n=sc.nextInt();
        if(n==0){
            System.out.println("Kích thước rỗng");
        }
        int [] arr = new int[n];
        int countEven=0;
        System.out.println("Nhập lần lượt từng phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("Mảng sau khi đảo ngược là: ");
        System.out.print("[");
        for (int i =arr.length-1; i>=0 ; i--) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }
}
