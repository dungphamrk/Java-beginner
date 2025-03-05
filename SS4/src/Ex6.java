import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên từ bàn phím: ");
        n = Integer.parseInt(sc.nextLine());
        int sum=0;
        while(n!=0){
            int lastDigits= n%10;
            n=n/10;
            if(lastDigits<0){
                lastDigits=lastDigits*-1;
            }
            sum+=lastDigits;
        }
        System.out.println("Tổng các chữ số là: "+sum);

    }
}
