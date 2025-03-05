import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= 0;
        int sum=0;
        do {
          n=sc.nextInt();
          sum+=n;
        }while(n==0);
        System.out.println("Tổng các số đã nhập là: "+sum );
    }
}
