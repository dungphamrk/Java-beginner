import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int a=0;
        int b=0;
        int c=0;
        Scanner sc =new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");
        a=sc.nextInt();
        System.out.print("Nhập số thứ hai: ");
        b=sc.nextInt();
        System.out.print("Nhập số thứ ba: ");
        c=sc.nextInt();
        if(a>b && a>c){
            System.out.println("Số lớn nhất là: "+ a );
        }else if(b>c && b>a){
            System.out.println("Số lớn nhất là: "+ b );
        }else if(c>a && c>b){
            System.out.println("Số lớn nhất là: "+ c);
        }else{
            System.out.println("3 số nguyên bằng nhau ");
        }
    }
}
