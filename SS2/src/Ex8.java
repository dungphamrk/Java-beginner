import java.util.Scanner;
public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] initialPoint = new int[5];
        int avgPoint = 0;
        for (int i = 0; i <5 ; i++) {
            initialPoint[i]= sc.nextInt();
            avgPoint+=initialPoint[i];
        }
        avgPoint= avgPoint/5;
        System.out.println(avgPoint);
    }
}
