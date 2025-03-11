import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StringBuilder str= new StringBuilder(sc.nextLine());
        String newStr= str.toString().toLowerCase();
       if(newStr.equals(str.reverse().toString().toLowerCase())){
           System.out.println("Chuỗi đối xứng");
       }
       else {
           System.out.println("Chuỗi không đối xứng");
       }
    }
}
