import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=0;
        System.out.print("Nhập số phần tử của mảng: ");
        n=sc.nextInt();
        int [] arr = new int[n];
        int maxOdd=0;
        int minOdd=0;
        System.out.println("Nhập lần lượt từng phần tử của mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
            if(arr[i]%2!=0&&maxOdd==0){
                maxOdd=arr[i];
                minOdd=arr[i];
            }
        }

        for(int value : arr){
            if (value%2!=0 && value>maxOdd){
                maxOdd=value;
            }
            if (value%2!=0 && value<minOdd){
                minOdd=value;
            }
        }
        if(maxOdd==0){
            System.out.println("Ko có số nguyên dương lẻ");
        }else {
            System.out.println("lẻ nguyên dương lớn nhất là " + maxOdd);
            System.out.println(" lẻ nguyên dương nhỏ nhất là " + minOdd);
        }
    }
}
