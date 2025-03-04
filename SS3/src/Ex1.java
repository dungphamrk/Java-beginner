import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int a=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần kiểm tra: ");
        a = sc.nextInt();
        if(a==0) System.out.println("Số không phải chẵn cũng không phải lẻ.");
        if(a%2==0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}
