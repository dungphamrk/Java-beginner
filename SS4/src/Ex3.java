import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        int n=0;
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập vào 1 số nguyên dương: ");
        n=sc.nextInt();
        if(n<0){
            System.out.println("Số nhập vào không hợp lệ");
            System.exit(0);
        }
        for(int i=1;i<=n;i++){
            System.out.println(n +" x "+i+" = "+n*i );
        }
        sc.close();
    }
}
