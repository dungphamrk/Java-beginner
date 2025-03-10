import java.util.Scanner;

public class Ex1 {
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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.printf("numbers [%d] : ", i);
            numbers[i] = sc.nextInt();
        }
        System.out.print("Các phần tử của mảng : ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d\t", numbers[i]);
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println();

        System.out.println("Giá trị lớn nhất : " + max);
        System.out.println("Giá trị nhỏ nhất : " + min);
    }
}
