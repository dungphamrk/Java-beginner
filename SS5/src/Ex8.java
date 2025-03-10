import java.util.Scanner;

public class Ex8 {
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
            int [] unique=new int[1000000];
            for(int value:arr){
                unique[value]++;
            }

            System.out.print("[");
            for (int i = 0; i < unique.length; i++) {
                if(unique[i]==1){
                    System.out.print(i+", ");
                }
            }
            System.out.println("]");
        }
    }
}
