import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int n=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập vào số n");
        n=sc.nextInt();
        if(n<2){
            System.out.println(n+" Không phải số nguyên tố");
            System.exit(0);
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(n+" Không phải số nguyên tố");
                System.exit(0);
            }
        }
        System.out.println(n+" là số nguyên tố");
    }
}
