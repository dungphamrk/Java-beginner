import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        try {
            int result=a/0;
            int result2=b/0;
        }catch(ArithmeticException e1){
            System.out.println("Lỗi , không thể chia cho 0");
        }catch( Exception e) {
            e.printStackTrace();
        }
    }
}
