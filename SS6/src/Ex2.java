import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        String regexEmail="^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
        String initialEmail="";
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Nhập email:");
            initialEmail=sc.nextLine();
            if(initialEmail.matches(regexEmail)){
                break;
            }else{
                System.out.println("Email không hợp lệ");
            }
        }
        System.out.println("Email hợp lệ ");
    }
}
