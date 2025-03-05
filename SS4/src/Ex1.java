import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int n=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập 1 số: ");
        n=sc.nextInt();
        if(n<1){
            System.out.println("Số nhập vào không hợp lệ");
            System.exit(0);
        }
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        System.out.println("Tổng các số từ 1 đến "+n+"là"+sum);
    }
}
