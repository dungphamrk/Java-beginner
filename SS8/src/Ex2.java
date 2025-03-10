import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        while(true){
            System.out.print("Nhập số phần tử của mảng : ");
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Kích thước ko hợp lệ. Vui lòng nhập lại");
            }else{
                break;
            }
        }
        int[] numbers = new int[n];
        int sum = 0;
        boolean isFlag = false;
        for (int i = 0; i < n; i++) {
            System.out.printf("numbers[%d] : ",i);
            numbers[i] = sc.nextInt();
        }
        System.out.print("Các phần tử của mảng : ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d\t",numbers[i]);
            if (numbers[i] %3 == 0) {
                sum += numbers[i];
                isFlag = true;
            }
        }
        System.out.println();
        if(isFlag) {
            System.out.println("Tổng = "+sum);
        }else {
            System.out.println("Không có số chia hết cho 3");
        }
    }
}
