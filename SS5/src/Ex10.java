import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=0;
        System.out.print("Nhập số phần tử của mảng: ");
        n=sc.nextInt();
        int [] arr = new int[n];
        if(n==0){
            System.out.println("Mảng không có phần tử");
        }else {
            int tempStart=0;
            int start=0;
            int end=0;
            System.out.println("Nhập lần lượt từng phần tử của mảng: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
            int maxSum=arr[0];
            int currentSum=0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > currentSum + arr[i]) {
                    currentSum = arr[i];
                    tempStart = i;
                } else {
                    currentSum += arr[i];
                }
                if(maxSum<currentSum){
                    maxSum=currentSum;
                    start=tempStart;
                    end=i;
                }
            }
            System.out.print(maxSum+"Dãy con [");
            for (int i = start; i < end; i++) {
                System.out.print(arr[i]+", ");
            }
            System.out.print("]");

        }
    }
}
