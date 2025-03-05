import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
        int n=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên dương n");
        n=sc.nextInt();
        if(n<1){
            System.out.println("Số được nhập không hợp lệ ");
            System.exit(0);
        }
        int sum=0;
        int countPerfect=0;
        System.out.println("Các số hoàn hảo nhỏ hơn " + n + " là: ");
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                if(i%j==0){
                    sum+=j;
                }
            }
            if (sum==n){
                System.out.print(n);
                countPerfect++;
            }
        }
        if(countPerfect==0){
            System.out.println("Không có số hoàn hảo nhỏ hơn "+ n);
        }

    }
}
