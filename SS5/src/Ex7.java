import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=0;
        System.out.print("Nhập số phần tử của mảng: ");
        n=sc.nextInt();
        int [] arr = new int[n];
        if(n==0){
            System.out.println("Mảng không có phần tử");
        }else {
            System.out.println("Nhập lần lượt từng phần tử của mảng: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int[] evenArr = new int[n];
            int[] oddArr = new int[n];
            int countEven = 0;
            int countOdd = 0;
            for (int value : arr) {
                if (value % 2 == 0) {
                    evenArr[countEven] = value;
                    countEven++;
                } else {
                    oddArr[countOdd] = value;
                    countOdd++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (i<countEven) {
                    arr[i] = evenArr[i];
                }
                else {
                    arr[i] = oddArr[i-countEven];
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
